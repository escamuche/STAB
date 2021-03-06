package com.stab.pf.info.equipment;

import com.stab.model.info.BaseInfo;
import com.stab.pf.StabConstants;

public class ThrownWeapon extends RangedWeapon {

	
	public ThrownWeapon(String name,int numberofDice, int dice, int baseDamageType, 
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,1,2,animationIcon,animationType);
	}
	
	public ThrownWeapon(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,critRange,2,animationIcon,animationType);
	}
	
	public ThrownWeapon(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			int critMultiplier, String animationIcon, String animationType) {
		super(name,numberofDice,dice,baseDamageType,critRange,critMultiplier,animationIcon,animationType);
	}
	
	protected int getDamageModifier(BaseInfo i) {
		
		int d=i.getValue(StabConstants.DAMAGE);
		if (isTwoHanded()) //Realmente, comprobar si esta en both hands
			d=(int)(d*1.5);
		//Mirar si esta en la off hand y meter menos da�o
		return d;
	}
}
