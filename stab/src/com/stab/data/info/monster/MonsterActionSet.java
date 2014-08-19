package com.stab.data.info.monster;

import com.stab.data.actions.general.DefendAction;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.GearSlotDelegatedAction;

public class MonsterActionSet extends BasicActionSet {

	public MonsterActionSet() {
		//this.addAction(PathfinderWeaponAttackAction.ID);
		GearSlotDelegatedAction sl1= new GearSlotDelegatedAction(null, HumanoidGear.MAINHAND, 0);
		this.addAction(sl1);
		this.addAction(DefendAction.ID);
	}
	
}
