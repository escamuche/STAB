package com.stab.data.actions.player.spells.cleric.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class Stabilize extends SpellOnTarget{
	
	public static final String ID="STABILIZE";

	@Override
	public boolean execute(Info yo, Info target) {
		return false;
	}
	
	public Stabilize() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
     setRange(2);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_druid_naturalperfection");
     setName("PurifyFood");
     this.setEffectType(HEAL);
	}
}