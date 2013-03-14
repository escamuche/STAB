package com.stab.data.info.equipment;

import com.stab.data.info.applicable.AttackData;
import com.stab.util.Roll;

/**
 * arma basica, con los datos principales
 * notese que puede tener traits añadidos (ej: veneno, un buff temporal, etc)
 * por ejemplo si es de flaming, seria un trait del arma.
 * el encantamiento de +1 ... pensarselo, probablemente sea una buena idea, pero se pueden liar los modificadores
 * (quizas meter una estructura de modificadores en attackdata, aunque suene muy complejo)
 *
 */
public class BasicWeapon extends Weapon {

	
	int dice; 
	int dices;
	int baseDamageType;
	int critRange;
	int critMultiplier;
	
	String animationIcon;
	String animationType;
	
	public BasicWeapon() {
		this.setPriority(10);  //Prioridad base para las armas.  Los overrides usaran una posterior, y los encantamientos tambien
	}
	
	
	public BasicWeapon(String name,int numberofDice, int dice, int baseDamageType, 
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,1,2,animationIcon,animationType);
	}
	
	public BasicWeapon(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,critRange,2,animationIcon,animationType);
	}
	
	public BasicWeapon(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			int critMultiplier, String animationIcon, String animationType) {
		this();
		this.setName(name);
		this.dice = dice;
		this.dices = numberofDice;
		this.baseDamageType = baseDamageType;
		this.critRange = critRange;
		this.critMultiplier = critMultiplier;
		this.animationIcon = animationIcon;
		this.animationType = animationType;
	}




	@Override
	public void attend(AttackData app) {
		super.attend(app);
		app.setBaseDamageType(baseDamageType);
		app.setCritMultiplier(critMultiplier);
		app.setCritRange(critRange);
		app.setBaseDamage(calcDamage(app));
		
		app.setAnimationIcon(animationIcon);
		app.setAnimationType(animationType);
		
		//mirar los traits anidados? o eso ya se hacia automaticamente, creo
		
	}

	
	

	protected int calcDamage(AttackData app){
		int i=rollDamage();
		i=i+getDamageModifier(app);
		return i;
	}

	protected int getDamageModifier(AttackData app) {
		return 0;
	}


	protected int rollDamage() {
		return Roll.roll(dices, dice);
	}
	
	protected void setDice(int number,int dice){
		dices=number;
		this.dice=dice;
	}
	
	public void setAnimationIcon(String animationIcon) {
		this.animationIcon = animationIcon;
	}
	public String getAnimationIcon() {
		return animationIcon;
	}
	public void setAnimationType(String animationType) {
		this.animationType = animationType;
	}
	public String getAnimationType() {
		return animationType;
	}
	public void setCritMultiplier(int critMultiplier) {
		this.critMultiplier = critMultiplier;
	}
	public void setCritRange(int critRange) {
		this.critRange = critRange;
	}
	public int getCritMultiplier() {
		return critMultiplier;
	}
	public int getCritRange() {
		return critRange;
	}
	
	public void setBaseDamageType(int baseDamageType) {
		this.baseDamageType = baseDamageType;
	}
	public int getBaseDamageType() {
		return baseDamageType;
	}
	
}
