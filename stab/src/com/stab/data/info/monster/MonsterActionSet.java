package com.stab.data.info.monster;

import com.stab.data.actions.WeaponAttackAction;
import com.stab.model.action.BasicActionSet;

public class MonsterActionSet extends BasicActionSet {

	public MonsterActionSet() {
		this.addAction(WeaponAttackAction.ID);
	}
	
}
