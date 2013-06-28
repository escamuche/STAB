package com.stab.data.info.equipment;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.WeaponAttack;
import com.stab.model.info.BaseInfo;

public class SpellDeliverWeapon extends BasicWeapon {

	int maxRange=1000;
	boolean ranged=true;
	
	
	
	public SpellDeliverWeapon(String name,int numberofDice, int dice, int baseDamageType, 
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,1,2,animationIcon,animationType);
	}
	
	public SpellDeliverWeapon(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,critRange,2,animationIcon,animationType);
	}
	
	public SpellDeliverWeapon(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			int critMultiplier, String animationIcon, String animationType) {
		super(name,numberofDice,dice,baseDamageType,critRange,critMultiplier,animationIcon,animationType);
		this.setTouch(true);
		setCategory(BasicWeapon.SPECIAL);
	}

	@Override
	public void affect(WeaponAttack app) {
		super.affect(app);
		app.setRanged(ranged);
	}
	
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}
	public int getMaxRange() {
		return maxRange;
	}
	
	@Override
	protected int getDamageModifier(WeaponAttack app) {
		
		return 0;
	}
	
	public void setRanged(boolean ranged) {
		this.ranged = ranged;
	}
	
	
	@Override
	public void setBaseItem(String baseItem) {
		// TODO Auto-generated method stub
		super.setBaseItem(baseItem);
		this.setResource("items/"+baseItem);
	}
	
}
