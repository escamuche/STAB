package com.stab.data.actions.player.spells;

import com.stab.model.action.Action;

public abstract class SpellOnSelf extends SpellAction   {

	
	public SpellOnSelf() {
		setTargetMode(Action.SELF);
	}
	
}
