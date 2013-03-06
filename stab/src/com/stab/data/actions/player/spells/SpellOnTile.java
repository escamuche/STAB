package com.stab.data.actions.player.spells;

import com.stab.model.action.TileAction;

public abstract class SpellOnTile extends TileAction  implements Spell {

	int level=0;
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	
}
