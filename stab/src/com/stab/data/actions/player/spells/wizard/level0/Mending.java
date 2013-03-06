package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class Mending extends SpellOnTarget{
	
	public static final String ID="MENDING";

	@Override
	public boolean execute(Info yo, Info target) {
		return false;
	}
	
	public Mending() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
     setRange(2);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_druid_naturalperfection");
     setName("Mending");
     this.setEffectType(HEAL);
	}
}
