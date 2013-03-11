package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class RemoveFear extends SpellOnTarget{
	
	public static final String ID="REMOVEFEAR";

	@Override
	public boolean execute(Info yo, Info target) {
		return false;
		}
	
	public RemoveFear() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_shaman_watershield");
     setName("Remove Fear");
     this.setEffectType(SPECIAL);
	}
}
