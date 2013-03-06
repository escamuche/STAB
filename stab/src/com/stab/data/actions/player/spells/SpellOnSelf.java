package com.stab.data.actions.player.spells;

import com.stab.model.action.SelfAction;

public abstract class SpellOnSelf extends SelfAction  implements Spell {

	int level=0;
		
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	
}
