package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class Command extends SpellOnTarget{
	
	public static final String ID="COMMAND";

	@Override
	public boolean execute(Info yo, Info target) {
		return false;
		}
	
	public Command() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/command");
     setName("Command");
     this.setEffectType(DEBUFF);
	}
}
