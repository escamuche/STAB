package com.stab.data.actions.player.spells;

import com.stab.model.action.TargetAction;

public abstract class SpellOnTarget extends TargetAction implements Spell {

	int level=0;
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	
}
