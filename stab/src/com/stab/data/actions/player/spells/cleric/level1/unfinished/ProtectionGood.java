package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;

public class ProtectionGood extends SpellOnTarget{
	
	public static final String ID="PROTECTIONGOOD_CLERIC";


	
	public ProtectionGood() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(1);
     
     setResource("actions/ability_shaman_watershield");
     setName("Protection Good");
     this.setEffectType(BUFF);
	}
}