package com.stab.data.info.monster;

import com.stab.data.actions.monster.ZombieClawAction;
import com.stab.data.actions.player.Kill;
import com.stab.model.action.BasicActionSet;

public class MeleeMonsterActionSet extends BasicActionSet {

	public MeleeMonsterActionSet() {
		this.addAction(ZombieClawAction.ID);
	}
	
}
