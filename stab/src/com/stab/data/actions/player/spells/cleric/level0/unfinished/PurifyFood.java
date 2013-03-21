package com.stab.data.actions.player.spells.cleric.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class PurifyFood extends SpellOnTarget{
	
	public static final String ID="PURIFYFOOD";

	@Override
	public boolean execute(Info yo, Info target) {
		return false;
	}
	
	public PurifyFood() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
     setRange(2);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_druid_naturalperfection");
     setName("PurifyFood");
     this.setEffectType(HEAL);
	}
}