package com.stab.pf.actions.player.spells.lvl0.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTarget;

public class PurifyFood extends SpellOnTarget{
	
	public static final String ID="PURIFYFOOD";


	
	public PurifyFood() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
     setRange(2);
     
     setResource("actions/ability_druid_naturalperfection");
     setName("PurifyFood");
     this.setEffectType(HEAL);
	}
}