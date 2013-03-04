package com.stab.data.actions.player;


import com.stab.data.actions.player.spells.Bless;
import com.stab.data.actions.player.spells.CureLight;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.EmptyAction;
import com.stab.model.action.base.InteractAction;


public class ClericActionSet extends BasicActionSet {

	public ClericActionSet() {
		for (int f=0;f<10;f++)
			this.addAction(EmptyAction.ID);
		
		
		this.setAction(InteractAction.ID,18);
		this.setAction(DefendAction.ID,19);
		this.setAction(Kill.ID, 10);
		this.setAction(Bless.ID, 12);
		this.setAction(RangedKill.ID, 11);
		this.setAction(CureLight.ID, 13);
		
	}
}