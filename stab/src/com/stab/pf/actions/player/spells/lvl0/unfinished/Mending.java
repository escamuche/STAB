package com.stab.pf.actions.player.spells.lvl0.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTarget;

public class Mending extends SpellOnTarget{
	
	public static final String ID="MENDING_CLERIC";


	
	public Mending() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
     setRange(2);
     
     setResource("actions/ability_druid_naturalperfection");
     setName("Mending");
     this.setEffectType(HEAL);
	}
}