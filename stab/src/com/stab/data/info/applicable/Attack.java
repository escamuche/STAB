package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.AdvancedRollApplicable;
import com.stab.model.info.applicable.Applicable;
import com.stab.util.Roll;

public class Attack extends AdvancedRollApplicable{

	
	public static final int HIT = SUCCESS;
	public static final int MISS = FAIL;

	//En un futuro añadir o reutilizar los que hay para "le has dado a una imagen" o "fallo por concealment", etc
	//Añadir tambien si ha sido CA, dodge, cover, parry o block lo que ha parado el ataque (con vistas a animacion)
	

	AttackData ad;
	
	int confirmMod=0;  //Bono a confirmar
	
	public Attack(BaseInfo instigator) {
		super(instigator);
		setDice(20);
		setCritRange(1);
		setBotchRange(1);
		ad=null;
	}
	
	
	public void setAttackData(AttackData ad) {
		this.ad = ad;
	}
	public AttackData getAttackData() {
		return ad;
	}
	
	public void setConfirmMod(int confirmMod) {
		this.confirmMod = confirmMod;
	}

	public int getConfirmMod() {
		return confirmMod;
	}
	
	public void addConfirmMod(int v){
		confirmMod+=v;
	}
	
	@Override
	public void setInstigator(Info instigator) {
		super.setInstigator(instigator);
		setModifier(((BaseInfo)instigator).getValue(StabConstants.TOHIT));
	}
	
	@Override
	public void setTarget(BaseInfo target) {
		super.setTarget(target);
		setTargetNumber(target.getValue(StabConstants.ARMOR));
	}

	/*
	@Override
	public void apply() {
		BaseInfo aMatar = getTarget();
		BaseInfo elqueMata = (BaseInfo) getInstigator();
		
		
		int dado = Roll.d20();

		ac=ac; 

		hit=hit+modificador;
		System.out.println(dado + " en el dado!");
		
		
		if (dado >= (21-critRange)) {
			System.out.println("Posibilidad de Critico!");
			int confirc=Roll.d20();
			int caconfirc=hit + confirc+ confirmMod;
			if(ac <= caconfirc) {
				System.out.println("Critico!!!");
				setResult(CRITICAL);
			   	}
			else{
				System.out.println("Fallaste la confirmacion!");
				setResult(HIT);
				}
			}
		
		
		if (dado == 1) {
			System.out.println("Posibilidad de Pifia!");
		    int confirp=Roll.d20();
		    int caconfirp=hit + confirp+ confirmMod;
		    if(ac <= caconfirp) {
		    	System.out.println("Casi!");
		    	setResult(MISS);
		    	}
		    	else{
		    		System.out.println("Pifia!!!");
		    		setResult(BOTCH);
		    		}
			}
		
		
		int dar = elqueMata.getValue(StabConstants.TOHIT) + dado;
		System.out.println("Impactas a armadura " + dar);
	
		if (ac <= dar) { //si das a ca
			setResult(HIT);
		}
		else{
			setResult(MISS);
		}
					
	}
	/**/
	
	@Override
	protected boolean checkCritical(int roll) {
		if (super.checkCritical(roll)){
			int n=Roll.d20()+getModifier()+getConfirmMod();
			if (n>=getTargetNumber())
				return true;
		}
		return false;
	}
	
	protected boolean checkBotch(int roll){
			if (super.checkBotch(roll)){
			int n=Roll.d20()+getModifier()+getConfirmMod();
			if (n<getTargetNumber())
				return true;
		}
		return false;
	}
	

	
	
	public boolean hits(){
		return getResult()==HIT || getResult()==CRITICAL;
	}
	
	public boolean misses(){
		return !hits();
	}
	
	public boolean isCritical(){
		return getResult()==CRITICAL;
	}
	public boolean isBotch(){
		return getResult()==BOTCH;
	}


	@Override
	public void apply() {
		if (getAttackData()!=null)
			for (Applicable d:getAttackData().getEffects(isCritical())){
				getTarget().apply(d);
				//System.out.println(d.getFinalAmount()+" de daño (tipo "+d.getType()+")");
			}
		
	}
	
	@Override
	public void validate() {
	
		super.validate();
		System.out.println("Ataque: "+this.getClass().getSimpleName()+" con "+ad.getWeapon().getName()+"  roll "+getRollResult()+" + "+getModifier()+"   against "+getTargetNumber()+"  result: "+getResult()+" (hits:"+hits()+" critical: "+isCritical()+" botch: "+isBotch()+")");
	}
	
	@Override
	public void setResult(int result) {
		super.setResult(result);
	}
	
}
