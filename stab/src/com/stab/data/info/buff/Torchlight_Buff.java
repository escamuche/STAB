package com.stab.data.info.buff;

import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.LightDecorToken;
import com.stab.model.info.trait.base.BuffEffect;

public class Torchlight_Buff extends BuffEffect {

	public Torchlight_Buff() {
		setPermanent();
	}
	
	
	@Override
	protected Sprite createEffectSprite() {
		LightDecorToken light= new LightDecorToken ();
		light.setLightIntensity(9);
		//light.setResource("PARTICLE#brazier");
		//light.setResource("Palanca_icono");
		//light.setDepth(20);
		return light;
	}
	
}
