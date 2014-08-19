package com.stab.data.actions.player.spells.lvl0.effects;

import com.stab.data.info.buff.Torchlight_Buff;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.LightDecorToken;
import com.stab.model.info.BaseInfo;

public class Light_Buff extends Torchlight_Buff{

	LightInUse inUseTrait = null;
	
	public LightInUse getInUseTrait() {
		return inUseTrait;
	}
	
	public void setInUseTrait(LightInUse inUseTrait) {
		this.inUseTrait = inUseTrait;
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		if(inUseTrait!=null){
			inUseTrait=null;
		}
		super.removeFrom(baseInfo);
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
