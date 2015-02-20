package com.stab.pf.actions;

import com.stab.data.actions.general.DefendAction;
import com.stab.data.actions.general.PassDefendAction;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.GearSlotDelegatedAction;
import com.stab.model.action.base.InteractAction;
import com.stab.model.action.base.SearchAction;
import com.stab.model.action.base.TinkerAction;
import com.stab.pf.info.equipment.HumanoidGear;


public class PathfinderActionSet extends BasicActionSet {
	
	

	public PathfinderActionSet() {
		super(20);
		
		GearSlotDelegatedAction sl1= new GearSlotDelegatedAction(null, HumanoidGear.MAINHAND, 0);
		//this.addAction(PathfinderWeaponAttackAction.ID);
		sl1.setCanonicalResource("ui/righthand");
		this.addAction(sl1);
		this.setAction(sl1, 0);
		
		this.addAction(DefendAction.ID);
		this.addAction(SearchAction.ID);
		this.addAction(TinkerAction.ID);
		this.addAction(PassDefendAction.ID);
		
		
		//this.setAction(PathfinderWeaponAttackAction.ID, 0);
		this.setAction(InteractAction.ID,8);
		this.setAction(PassDefendAction.ID,9);
	//	this.setAction(PassAction.ID,19);
		this.setAction(SearchAction.ID,7);
		this.setAction(TinkerAction.ID,18);
		//stealth 17
		//trip, disarm, rush?
		//aid, protect?
		//first aid?
		
	}	
}