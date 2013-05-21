package com.stab.data.actions.player;

import com.stab.data.actions.PathfinderSearchAction;
import com.stab.data.actions.WeaponAttackAction;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.InteractAction;


public class PathfinderActionSet extends BasicActionSet {
	
	

	public PathfinderActionSet() {
		super(20);
		this.addAction(WeaponAttackAction.ID);
		this.addAction(DefendAction.ID);
		this.addAction(PathfinderSearchAction.ID);
		
		
		this.setAction(WeaponAttackAction.ID, 0);
		this.setAction(InteractAction.ID,8);
		this.setAction(DefendAction.ID,9);
		this.setAction(PathfinderSearchAction.ID,7);
		//stealth
		//trip, disarm, rush?
		//aid, protect?
		//first aid
		
	}	
}