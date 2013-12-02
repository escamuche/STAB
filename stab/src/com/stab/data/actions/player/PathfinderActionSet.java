package com.stab.data.actions.player;

import com.stab.data.actions.general.DefendAction;
import com.stab.data.actions.general.WeaponAttackAction;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.InteractAction;
import com.stab.model.action.base.SearchAction;


public class PathfinderActionSet extends BasicActionSet {
	
	

	public PathfinderActionSet() {
		super(20);
		this.addAction(WeaponAttackAction.ID);
		this.addAction(DefendAction.ID);
		this.addAction(SearchAction.ID);
		
		
		this.setAction(WeaponAttackAction.ID, 0);
		this.setAction(InteractAction.ID,8);
		this.setAction(DefendAction.ID,9);
		this.setAction(SearchAction.ID,7);
		//stealth
		//trip, disarm, rush?
		//aid, protect?
		//first aid
		
	}	
}