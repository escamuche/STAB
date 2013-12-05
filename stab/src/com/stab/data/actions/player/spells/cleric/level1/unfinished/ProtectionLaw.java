package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;

public class ProtectionLaw extends SpellOnTarget{
	
	public static final String ID="PROTECTIONLAW_CLERIC";

	
	
	public ProtectionLaw() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(1);
     
     setResource("actions/ability_shaman_watershield");
     setName("Protection Law");
     this.setEffectType(BUFF);
	}
}
