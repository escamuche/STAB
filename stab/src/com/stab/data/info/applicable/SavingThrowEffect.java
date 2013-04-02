package com.stab.data.info.applicable;

import java.util.ArrayList;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.Modifier;

public  class SavingThrowEffect extends SkillRoll {

	
	
	
	
	boolean nullIfSuccess;
	ArrayList<Applicable> toApplyPass;
	
	/**
	 * Usar esta version si no importa el instigador.
	 * @param save atributo a tirar
	 * @param diff dificultad
	 */
	public SavingThrowEffect( String save, int diff){
		this(null, save, diff);
	}
	
	/**
	 * 
	 * Usar esta version si nos interesa pasar el instigador (ej: quien nos hace tirar la salvacion)
	 * como siempre, es el target quien apply( savingthrow); o check(savingThrow);  
	 * @param instigator    Quien causa el efecto
	 * @param save			Que atributo tirar
	 * @param diff			la dificultad, ya calculada de antemano.
	 */
	public SavingThrowEffect(Info instigator, String save, int diff) {
		super(instigator, save, diff);
		nullIfSuccess=false;
		toApplyPass= new ArrayList<Applicable> ();
	}

	protected void recalcMod(){
		ArrayList<Modifier>list=new ArrayList<Modifier>();
		list.addAll(((BaseInfo)getTarget()).getModifiers(getSkill()));
		list.addAll(getModifiers());
		setModifier(Modifier.getValue(list)+getModifier());
	}

	public void setNullIfSuccess(boolean nullIfSuccess) {
		this.nullIfSuccess = nullIfSuccess;
	}
	
	public boolean isNullIfSuccess() {
		return nullIfSuccess;
	}
	
	@Override
	protected int evalRoll(int roll) {
		int i= super.evalRoll(roll);
		
		if (isNullIfSuccess() && i==SUCCESS)
			i=NEUTRALIZED;
		
		return i;
			
	}
	
	@Override
	public boolean success() {
		if (isEvaded())
			return true;
		return super.success();
	}
	
	public boolean isEvaded(){
		return getResult()==NEUTRALIZED;
	}
	
	
	@Override
	public void apply() {
		if (isEvaded())
			return;
		if (success()){
			for (Applicable a:toApplyPass)
				getTarget().apply(a);
		}else
			super.apply();
	}
	
	public void addApplicablePass(Applicable a){
		toApplyPass.add(a);
	}
	
	
	public void addApplicable(Damage d,boolean halfDamage) {
		addApplicable(d);
		if (halfDamage){
			Damage d2=d.getCopy();
			d2.setAmount(d.getAmount()/2);
			addApplicablePass(d2);
		}
	}
	
}
