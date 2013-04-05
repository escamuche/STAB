package com.stab.data.info.applicable;

import java.util.ArrayList;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.trait.Modifier;
import com.stab.util.Roll;

public abstract class Attack extends SkillRoll{

	
	public static final int HIT = SUCCESS;
	public static final int MISS = FAIL;
	public static final int BLOCK = 20;
	public static final int PARRY = 21;
	public static final int DODGE = 22;
	public static final int ARMOR = 23;
	public static final int COVER = 24;

	//En un futuro añadir o reutilizar los que hay para "le has dado a una imagen" o "fallo por concealment", etc
	//Añadir tambien si ha sido CA, dodge, cover, parry o block lo que ha parado el ataque (con vistas a animacion)
	

	
	int confirmMod=0;  //Bono a confirmar
	
	boolean touch;
	boolean ranged;
	
	public Attack(BaseInfo instigator) {
		super(instigator,StabConstants.TOHIT,0);
		setDice(20);
		setCritRange(1);
		setBotchRange(1);
		touch=false;
	}
	
	
	public void setTouch(boolean touch) {
		this.touch = touch;
	}
	public boolean isTouch() {
		return touch;
	}
	
	public void setRanged(boolean b){
		ranged=b;
		if (b){
			setSkill(StabConstants.TOHITRANGED);
		}else
			setSkill(StabConstants.TOHIT);
		
	}
	
	public boolean isRanged() {
		return ranged;
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
	protected void recalcTarget() {
		BaseInfo target=getTarget();
		int i=10;
		if (isTouch()){
			i=target.getValue(StabConstants.PASSIVEDEFENSE);
			//TODO: comprobaciones unaware, flatfooted, etc
			i=i+target.getValue(StabConstants.ACTIVEDEFENSE);
		}
		else{
			i=target.getValue(StabConstants.PASSIVEDEFENSE);
			i=i+target.getValue(StabConstants.ARMORDEFENSE);
			i=i+target.getValue(StabConstants.SHIELDDEFENSE);
			//TODO: comprobaciones unaware, flatfooted, etc
			i=i+target.getValue(StabConstants.ACTIVEDEFENSE);
		}
		i=i+getTargetNumber();
		setFinalTargetNumber(i);	
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
		
	}
	
	@Override
	public void validate() {
	
		super.validate();
		
	}
	
	
	
	
	
	
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
