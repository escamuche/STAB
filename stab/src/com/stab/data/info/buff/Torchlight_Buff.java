package com.stab.data.info.buff;

import com.stab.model.basic.token.DecorToken;
import com.stab.model.basic.token.LightDecorToken;
import com.stab.model.info.trait.base.Buff;

public class Torchlight_Buff extends Buff {

	public Torchlight_Buff() {
		setPermanent();
	}
	
	
	@Override
	protected DecorToken createEffectToken() {
		LightDecorToken light= new LightDecorToken ();
		light.setLightIntensity(35);
		return light;
	}
	
}
