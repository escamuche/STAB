package com.stab.data.info.monster;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.Equipment;

public class Monster extends Creature {

	
	@Override
	public void init() {
		super.init();
		
		this.setActionSet(new MonsterActionSet());
		this.addTrait(new BasicAttributes());
		this.setGear(new HumanoidGear());   //si, si, ya, ya. ya lo separaremos en varias clases por tipo de monstruo
		setOverlay("border");
	}
	
	public void postInit(){
		rollHp();
	}
	
	@Override
	public void rollInitiative() {
		setInitiative(Roll.d20()+getValue(StabConstants.INICIATIVEMOD));
	}
	
	

	public boolean equip(String s) {
		Equipment e= StabInit.getWeaponFactory().getWeapon(s);
		if (e==null)
			e=StabInit.getArmorFactory().getArmor(s);
		if (e==null)
			e=StabInit.getEquipmentFactory().getItem(s); 
		if (e==null)
			return false;
		return super.equip(e);
	}
	
	
	private void rollHp(){
		if (StabConstants.USEMAXHPFORMONSTERS){
			int hp=getValue(StabConstants.HITDICENUMBER)*getValue(StabConstants.HITDICETYPE);
			setMaxHp(hp);
			healFully();
		}else{
			int hp=Roll.roll(getValue(StabConstants.HITDICENUMBER),getValue(StabConstants.HITDICETYPE));
			setMaxHp(hp);
			healFully();
		}
		
	}
	
	@Override
	public void setMaxHp(int maxHp) {
		setAttribute(StabConstants.MAXHP,maxHp);
		super.setMaxHp(maxHp);
	}
	
	@Override
	public int getMaxHp() {
		return getValue(StabConstants.MAXHP);
	}
	
	@Override
	public void setMaxEp(int maxHp) {
		setAttribute(StabConstants.MAXMP,maxHp);
		super.setMaxHp(maxHp);
	}
	
	@Override
	public int getMaxEp() {
		return getValue(StabConstants.MAXMP);
	}
	
	
}
