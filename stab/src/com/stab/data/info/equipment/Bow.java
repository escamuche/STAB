package com.stab.data.info.equipment;

import com.stab.data.animation.ShootProyectileAnimation;

public class Bow extends RangedWeapon {

	public Bow(String name,int numberofDice, int dice, int baseDamageType){
		this(name,numberofDice,dice,baseDamageType,"effects/arrow",ShootProyectileAnimation.ID);
	}
	public Bow(String name,int numberofDice, int dice, int baseDamageType, 
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,1,3,animationIcon,animationType);
	}
	
	public Bow(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,critRange,3,animationIcon,animationType);
	}
	
	public Bow(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			int critMultiplier, String animationIcon, String animationType) {
		super(name,numberofDice,dice,baseDamageType,critRange,critMultiplier,animationIcon,animationType);
		this.setUseAmmo(AMMO_SLOT);
		setTwoHanded(true);
	}
}