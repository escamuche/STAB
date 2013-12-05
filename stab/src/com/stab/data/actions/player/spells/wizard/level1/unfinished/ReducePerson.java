package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;

public class ReducePerson extends SpellOnTarget {
	
	public static final String ID="REDUCEPERSON";
	
	public ReducePerson() {
		setLevel(1);
		 setRange(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setResource("actions/ability_druid_naturalperfection");
     setName("ReducePerson");
     this.setEffectType(DEBUFF);
	}

	
}
