package com.stab.data.actions.player.spells.lvl0.effects;

import com.stab.model.info.base.LightDecoration;

public class DancingLights_effect extends LightDecoration {

	public static final String ID="DANCINGLIGHTS_EFFECT";
	
	@Override
	public void init() {
		super.init();
		this.setLightIntensity(9);
		this.setLightOn(true);
		this.setResource("SHADER#dancinglights");
		//TODO: tag dispeleable, asociar a un spelleffect, etc.
	}
	
}
