package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;

public class RemoveFear extends SpellOnTarget{
	
	public static final String ID="REMOVEFEAR";

	
	
	public RemoveFear() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(6);
     
     setResource("actions/ability_shaman_watershield");
     setName("Remove Fear");
     this.setEffectType(SPECIAL);
	}
}
