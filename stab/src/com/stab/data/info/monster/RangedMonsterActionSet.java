package com.stab.data.info.monster;

import com.stab.data.actions.monster.SkeletonRangedAction;
import com.stab.data.actions.monster.ZombieClawAction;
import com.stab.model.action.BasicActionSet;

public class RangedMonsterActionSet extends BasicActionSet {

	public RangedMonsterActionSet() {
		this.addAction(SkeletonRangedAction.ID);
	//	this.addAction(ZombieClawAction.ID);
	}
}