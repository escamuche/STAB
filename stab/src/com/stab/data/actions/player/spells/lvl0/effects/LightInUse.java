package com.stab.data.actions.player.spells.lvl0.effects;

import com.stab.model.info.trait.Effect;
import com.stab.model.info.trait.Trait;

public class LightInUse extends Trait {
	
	Effect buffEffect = null;
	public static String ID="LIGHTINUSE";
	
	public void setBuff(Effect buffEffect) {
		this.buffEffect = buffEffect;
	}
	
	public Effect getBuff() {
		return buffEffect;
	}
}
