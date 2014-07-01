package com.stab.data.info.applicable;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.gear.Weapon;

public  class PathfinderAttack extends WeaponAttack{

	
	public static final int BLOCK = 20;
	public static final int PARRY = 21;
	public static final int DODGE = 22;
	public static final int ARMOR = 23;
	public static final int COVER = 24;

	//En un futuro añadir o reutilizar los que hay para "le has dado a una imagen" o "fallo por concealment", etc
	//Añadir tambien si ha sido CA, dodge, cover, parry o block lo que ha parado el ataque (con vistas a animacion)
	

	
	int confirmMod=0;  //Bono a confirmar
	
	boolean touch;
	
	public PathfinderAttack(BaseInfo instigator,Weapon weapon,BaseInfo target) {
		super(instigator,StabConstants.TOHIT,weapon,target,StabConstants.AC);  //Realmente no se usa lo de AC (ver mas abajo en recalcTarget
		setDice(20);
		setCritRange(1);
		setBotchRange(1);
		touch=false;
	}
	
	public void setRanged(boolean b) {
		super.setRanged(b);
		if (b){
			setSkill(StabConstants.TOHITRANGED);
		}else
			setSkill(StabConstants.TOHIT);
	}
	
	public void setTouch(boolean touch) {
		this.touch = touch;
	}
	public boolean isTouch() {
		return touch;
	}
	
	@Override
	protected void recalcTarget() {
		BaseInfo target=getTarget();
		int i;
		i=Modifier.getModFrom(StabConstants.PASSIVEDEFENSE,target.getModifiers(StabConstants.PASSIVEDEFENSE),getTargetModifiers(StabConstants.PASSIVEDEFENSE));
		
		
			//TODO: comprobaciones unaware, flatfooted, etc
			i=i+Modifier.getModFrom(StabConstants.ACTIVEDEFENSE,target.getModifiers(StabConstants.ACTIVEDEFENSE),getTargetModifiers(StabConstants.ACTIVEDEFENSE));
		if (!isTouch()){
			i=i+Modifier.getModFrom(StabConstants.ARMORDEFENSE,target.getModifiers(StabConstants.ARMORDEFENSE),getTargetModifiers(StabConstants.ARMORDEFENSE));
			i=i+Modifier.getModFrom(StabConstants.SHIELDDEFENSE,target.getModifiers(StabConstants.SHIELDDEFENSE),getTargetModifiers(StabConstants.SHIELDDEFENSE));
		}
		i=i+getTargetNumber();
		setFinalTargetNumber(i);	
	}
	
	@Override
	protected boolean checkCritical(int roll) {
		if (super.checkCritical(roll)){
			int n=Roll.d20()+getModifier()+getConfirmMod();
			if (n>=getTargetNumber())
				return true;
		}
		return false;
	}

	protected boolean checkBotch(int roll) {
			if (super.checkBotch(roll)){
			int n=Roll.d20()+getModifier()+getConfirmMod();
			if (n<getTargetNumber())
				return true;
		}
		return false;
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
	protected int evalRoll(int roll) {
		int i= super.evalRoll(roll);
		//Comprobar blocked, parried, dodged
		if (i==MISS){
			int dif=getFinalTargetNumber()-getRollResult();
			BaseInfo t=getTarget();
			//En su momento pensarse COVER
			int shield=t.getValue(StabConstants.SHIELDDEFENSE);
			if (dif<=shield && !isTouch())
				return BLOCK;
			dif=dif-shield;
			int active=t.getValue(StabConstants.ACTIVEDEFENSE);
			if (dif<=active) //Aqui comprobar isFlatFooted
			 	return DODGE;
			dif=dif-active;
			int armor=t.getValue(StabConstants.ARMORDEFENSE);
			if (dif<=armor && !isTouch())
				return ARMOR;
				
			}
		
		return i;
	}
	
	
	
}
