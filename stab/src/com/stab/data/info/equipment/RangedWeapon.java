package com.stab.data.info.equipment;

import com.stab.data.info.applicable.AttackData;
import com.stab.data.info.applicable.RangedAttack;

public class RangedWeapon extends BasicWeapon {

	int maxRange=10;
	//en un futuro, range y range increments
	
	
	
	public RangedWeapon(String name,int numberofDice, int dice, int baseDamageType, 
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,1,2,animationIcon,animationType);
	}
	
	public RangedWeapon(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,critRange,2,animationIcon,animationType);
	}
	
	public RangedWeapon(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			int critMultiplier, String animationIcon, String animationType) {
		super(name,numberofDice,dice,baseDamageType,critRange,critMultiplier,animationIcon,animationType);
	}

	@Override
	public void attend(AttackData app) {
		super.attend(app);
		app.setAttack(new RangedAttack(null));
	}
	
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}
	public int getMaxRange() {
		return maxRange;
	}
	
}
