package com.stab.data.actions.player.spells.lvl0.effects;

import org.newdawn.slick.Color;

import com.stab.common.Constants;
import com.stab.model.basic.token.Token;
import com.stab.model.info.base.LightDecoration;

public class DancingLights_effect extends LightDecoration {

	public static final String ID="DANCINGLIGHTS_EFFECT";
	
	@Override
	public void init() {
		super.init();
		this.setSize(1, 1);
		this.setDepth(Constants.EFFECTS);
		this.setSelectable(Token.SELECTABLE_MENU);
		this.setLightIntensity(7);
		this.setLightOn(true);
		this.setLightColor(Color.red);
		this.setResource("SHADER#dancinglights");
		//TODO: tag dispeleable, asociar a un spelleffect, etc.
	}
	
}
