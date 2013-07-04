package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class ProtectionEvil extends SpellOnTarget{
	
	public static final String ID="PROTECTIONEVIL_CLERIC";

	
	
	public ProtectionEvil() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(1);
     
     setResource("actions/ability_shaman_watershield");
     setName("Protection Evil");
     this.setEffectType(BUFF);
	}
}
