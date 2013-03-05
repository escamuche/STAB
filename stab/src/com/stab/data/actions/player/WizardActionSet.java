package com.stab.data.actions.player;


import com.stab.data.actions.player.spells.wizard.level1.MagicMissile;
import com.stab.data.actions.player.spells.wizard.level1.Shield;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.EmptyAction;
import com.stab.model.action.base.InteractAction;


public class WizardActionSet extends BasicActionSet {

	public WizardActionSet() {
		for (int f=0;f<10;f++)
			this.addAction(EmptyAction.ID);
		
		
		this.setAction(InteractAction.ID,18);
		this.setAction(DefendAction.ID,19);
		this.setAction(WizardBasicMelee.ID, 10);
		this.setAction(MagicMissile.ID, 12);
		this.setAction(RangedKill.ID, 11);
		this.setAction(Shield.ID,17);
		
	}
	
	
	

	
}