package com.stab.data.actions.player.spells;

import com.stab.model.action.Action;

public abstract class SpellOnTarget extends SpellAction   {

	public SpellOnTarget() {
		setTargetMode(Action.TARGET);
	}
	
}
