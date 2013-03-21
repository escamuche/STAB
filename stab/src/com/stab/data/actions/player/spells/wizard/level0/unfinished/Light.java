package com.stab.data.actions.player.spells.wizard.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class Light extends SpellOnTarget{
	
	public static final String ID="LIGHT_WIZARD";

	@Override
	public boolean execute(Info yo, Info target) {
		return false;
		}
	
	public Light() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setRange(1);
		setTargetClass(PhysicalToken.class);
		setResource("actions/ability_druid_naturalperfection");
		setName("Light");
		this.setEffectType(BUFF);
	}
}
