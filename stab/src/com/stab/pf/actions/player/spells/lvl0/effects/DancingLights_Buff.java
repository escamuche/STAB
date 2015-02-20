package com.stab.pf.actions.player.spells.lvl0.effects;

import com.stab.model.info.trait.Effect;

public class DancingLights_Buff extends Effect{
	
	public static String ID="DANCINGLIGHTSINUSE";
	
	DancingLights_effect effect;
	
	public void setEffect(DancingLights_effect effect) {
		this.effect = effect;
	}
	public DancingLights_effect getEffect() {
		return effect;
	}
	
	public DancingLights_Buff() {
		setTime(10);
	}
	
	
	@Override
	public void end() {
		if (effect!=null)
			effect.destroy();
		super.end();
	}
}
