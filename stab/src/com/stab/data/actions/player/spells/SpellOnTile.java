package com.stab.data.actions.player.spells;

import com.stab.model.action.Action;

public abstract class SpellOnTile extends SpellAction  {

	public SpellOnTile() {
		setTargetMode(Action.TILE);
	}
	
	
}
