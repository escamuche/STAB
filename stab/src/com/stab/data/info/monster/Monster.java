package com.stab.data.info.monster;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.Equipment;
import com.stab.util.Roll;

public class Monster extends Creature {

	
	@Override
	public void init() {
		super.init();
		
		this.setActionSet(new MonsterActionSet());
		this.addTrait(new BasicAttributes());
		this.setGear(new HumanoidGear());   //si, si, ya, ya. ya lo separaremos en varias clases por tipo de monstruo
	}
	
	
	@Override
	public void rollInitiative() {
		setInitiative(Roll.d20()+getValue(StabConstants.INICIATIVEMOD));
	}
	
	

	public boolean equip(String s) {
		Equipment e= StabInit.getWeaponFactory().getWeapon(s);
		if (e==null)
			e=StabInit.getArmorFactory().getArmor(s);
		//if (e==null)
			//e=StabInit.getEquipmentFactory().getEquipment(s);
		if (e==null)
			return false;
		return super.equip(e);
	}
	
	
	public void rollHp(){
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
}
