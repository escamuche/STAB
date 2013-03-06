package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class DetectUndead extends SpellOnTarget{
	
	public static final String ID="DETECTUNDEAD";

	@Override
	public boolean execute(Info yo, Info target) {
		return false;
	}
	
	public DetectUndead() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_druid_naturalperfection");
     setName("DETECTUNDEAD");
     this.setEffectType(BUFF);
	}
}
