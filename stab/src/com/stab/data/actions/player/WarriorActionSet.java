package com.stab.data.actions.player;

import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.EmptyAction;
import com.stab.model.action.base.InteractAction;

public class WarriorActionSet extends BasicActionSet {

	public WarriorActionSet() {
		for (int f=0;f<10;f++)
			this.addAction(EmptyAction.ID);
		
		this.setAction(InteractAction.ID,18);
		this.setAction(DefendAction.ID,19);
		this.setAction(Kill.ID, 10);
		this.setAction(PowerAttack.ID, 11);
	
	}
	
	
	

	
}
