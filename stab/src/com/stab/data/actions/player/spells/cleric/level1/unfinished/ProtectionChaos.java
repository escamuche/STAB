package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;

public class ProtectionChaos extends SpellOnTarget{
	
	public static final String ID="PROTECTIONCHAOS_CLERIC";


	
	public ProtectionChaos() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(1);
     
     setResource("actions/ability_shaman_watershield");
     setName("Protection Chaos");
     this.setEffectType(BUFF);
	}
}
