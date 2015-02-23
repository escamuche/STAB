package com.stab.pf.info.monster;

import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.GearSlotDelegatedAction;
import com.stab.pf.actions.general.DefendAction;
import com.stab.pf.info.equipment.HumanoidGear;

public class MonsterActionSet extends BasicActionSet {

	public MonsterActionSet() {
		//this.addAction(PathfinderWeaponAttackAction.ID);
		GearSlotDelegatedAction sl1= new GearSlotDelegatedAction(null, HumanoidGear.MAINHAND, 0);
		this.addAction(sl1);
		this.addAction(DefendAction.ID);
	}
	
}
