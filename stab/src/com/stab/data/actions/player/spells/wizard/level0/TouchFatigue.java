package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class TouchFatigue extends SpellOnTarget{
	
	public static final String ID="TOUCHFATIGUE";

	@Override
	public boolean execute(Info yo, Info target) {
		return false;
	}
	
	public TouchFatigue() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_druid_naturalperfection");
     setName("TouchFatigue");
     this.setEffectType(DEBUFF);
	}
}
