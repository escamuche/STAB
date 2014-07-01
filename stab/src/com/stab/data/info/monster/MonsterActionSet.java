package com.stab.data.info.monster;

import com.stab.data.actions.general.DefendAction;
import com.stab.data.actions.general.PathfinderWeaponAttackAction;
import com.stab.model.action.BasicActionSet;

public class MonsterActionSet extends BasicActionSet {

	public MonsterActionSet() {
		this.addAction(PathfinderWeaponAttackAction.ID);
		this.addAction(DefendAction.ID);
	}
	
}
