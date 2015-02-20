package com.stab.pf.info.equipment;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.pf.StabConstants;

public class RangedWeapon extends BasicWeapon {

	int maxRange=20;
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
	public void affect(WeaponAttack app) {
		super.affect(app);
		app.setRanged(true);
	}
	
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}
	public int getMaxRange() {
		return maxRange;
	}
	
	@Override
	protected int getDamageModifier(BaseInfo i) {
		
		int d=i.getValue(StabConstants.DAMAGERANGED);
		//las armas thrown van por damage, ojo!
		return d;
	}
	
}
