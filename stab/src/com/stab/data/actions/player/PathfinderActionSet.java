package com.stab.data.actions.player;

import com.stab.data.actions.WeaponAttackAction;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.EmptyAction;
import com.stab.model.action.base.InteractAction;


public class PathfinderActionSet extends BasicActionSet {

	public PathfinderActionSet() {
		for (int f=0;f<10;f++)
			this.addAction(EmptyAction.ID);
		
		this.setAction(InteractAction.ID,18);
		this.setAction(DefendAction.ID,19);
		this.setAction(WeaponAttackAction.ID, 10);
		
	}	
}