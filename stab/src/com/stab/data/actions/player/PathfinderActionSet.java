package com.stab.data.actions.player;

import com.stab.data.actions.general.DefendAction;
import com.stab.data.actions.general.PathfinderWeaponAttackAction;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.InteractAction;
import com.stab.model.action.base.PassAction;
import com.stab.model.action.base.SearchAction;
import com.stab.model.action.base.TinkerAction;


public class PathfinderActionSet extends BasicActionSet {
	
	

	public PathfinderActionSet() {
		super(20);
		this.addAction(PathfinderWeaponAttackAction.ID);
		this.addAction(DefendAction.ID);
		this.addAction(SearchAction.ID);
		this.addAction(TinkerAction.ID);
		
		
		this.setAction(PathfinderWeaponAttackAction.ID, 0);
		this.setAction(InteractAction.ID,8);
		this.setAction(DefendAction.ID,9);
		this.setAction(PassAction.ID,19);
		this.setAction(SearchAction.ID,7);
		this.setAction(TinkerAction.ID,18);
		//stealth 17
		//trip, disarm, rush?
		//aid, protect?
		//first aid?
		
	}	
}