package com.stab.pf.info.applicable;

import java.awt.Color;
import java.util.ArrayList;
import java.util.EnumSet;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.OpposedSkillRoll;
import com.stab.model.info.trait.Modifier;
import com.stab.pf.actions.EffectDescriptor;

public  class SavingThrowEffect extends OpposedSkillRoll {

	
	
	
	
	boolean nullIfSuccess;
	ArrayList<Applicable> toApplyPass;
	
	EnumSet<EffectDescriptor> descriptors;
	
	
	/**
	 * 
	 * Usar esta version si nos interesa pasar el instigador (ej: quien nos hace tirar la salvacion)
	 * como siempre, es el target quien apply( savingthrow); o check(savingThrow);  
	 * @param instigator    Quien causa el efecto
	 * @param save			Que atributo tirar
	 * @param diff			la dificultad, ya calculada de antemano.
	 */
	public SavingThrowEffect(BaseInfo instigator, String save, BaseInfo target) {
		super(instigator, save, target,null);
		nullIfSuccess=false;
		toApplyPass= new ArrayList<Applicable> ();
	}

	protected void recalcMod(){
		ArrayList<Modifier>list=new ArrayList<Modifier>();
		list.addAll(((BaseInfo)getTarget()).getModifiers(getSkill()));
		list.addAll(getModifiers(getSkill()));
		setModifier(Modifier.getValue(list)+getModifier());
	}
	
	@Override
	protected void recalcTarget() {
		ArrayList<Modifier>list=new ArrayList<Modifier>();
		list.addAll(getTargetModifiers(null));
		setFinalTargetNumber(Modifier.getValue(list)+getTargetNumber());
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
	public void applyEffects() {
		if (isEvaded())
			return;
		if (success()){
			for (Applicable a:toApplyPass)
				getTarget().apply(a);
		}else{
			
			for (Applicable a:toApply)
				getTarget().apply(a);
		}
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
	
	
	@Override
	public void check() {
		super.check();
		animate();
	}
	
	
	public void animate(){
		if (isEvaded()){
			getTarget().showFloatingText("EVADED", Color.pink);
		}else
			if (success()){
				getTarget().showFloatingText("SAVE", Color.green);	
			}
	}
	
	@Override
	public void validate() {
		super.validate();
		System.out.println("Saving throw : "+this.getSkill()+" roll "+getRollResult()+" + "+getFinalModifier()+"   against "+getFinalTargetNumber()+"  result: "+getResult()+" (success:"+success()+" evaded: "+isEvaded()+" botch: "+isBotch()+")");
	}
	
	
	public EnumSet<EffectDescriptor> getDescriptors() {
		return descriptors;
	}
	
	public void setDescriptors(EnumSet<EffectDescriptor> descriptors) {
		this.descriptors = descriptors;
	}
	
	
}
