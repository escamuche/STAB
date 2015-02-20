package com.stab.pf.actions.player.spells.cleric.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTarget;

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
