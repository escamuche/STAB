package com.stab.pf.actions.player.spells.lvl0.effects;

import org.newdawn.slick.Color;

import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.LightDecorToken;
import com.stab.pf.info.buff.Torchlight_Buff;

public class Light_Effect extends Torchlight_Buff{


	public Light_Effect() {
		
	}
	
	
	@Override
	protected Sprite createEffectSprite() {
		LightDecorToken light= new LightDecorToken ();
		light.setLightIntensity(9);
		light.setLightColor(Color.blue);
		return light;
	}
}
