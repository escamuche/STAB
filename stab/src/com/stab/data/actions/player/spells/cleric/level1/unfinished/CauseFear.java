package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class CauseFear extends SpellOnTarget{
	
	public static final String ID="CAUSEFEAR_CLERIC";

	
	public CauseFear() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(6);
     setResource("actions/causefear");
     setName("CauseFear");
     this.setEffectType(DEBUFF);
	}
}
