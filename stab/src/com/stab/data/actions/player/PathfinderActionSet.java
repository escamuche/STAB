package com.stab.data.actions.player;

import com.stab.data.actions.WeaponAttackAction;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.InteractAction;


public class PathfinderActionSet extends BasicActionSet {

	public PathfinderActionSet() {
		
		this.addAction(WeaponAttackAction.ID);
		this.addAction(DefendAction.ID);
		
		
		this.setAction(WeaponAttackAction.ID, 0);
		this.setAction(InteractAction.ID,8);
		this.setAction(DefendAction.ID,9);
		
		
	}	
}