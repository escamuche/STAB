package com.stab.data.actions.player;

import com.stab.data.actions.WeaponAttackAction;
import com.stab.data.actions.feats.Expertise;
import com.stab.data.actions.feats.PowerAttack;
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
		this.setAction(PowerAttack.ID, 16);
		//this.setAction(Expertise.ID, 17);
		this.setAction(RangedKill.ID, 11);
	
		this.setAction(WeaponAttackAction.ID, 13);
	}	
}
