package com.stab.data.info.buff.spells;

import com.stab.model.info.trait.Trait;
import com.stab.model.info.trait.base.BuffEffect;

public class LightInUse extends Trait {
	
	BuffEffect buffEffect = null;
	public static String ID="LIGHTINUSE";
	
	public void setBuff(BuffEffect buffEffect) {
		this.buffEffect = buffEffect;
	}
	
	public BuffEffect getBuff() {
		return buffEffect;
	}
}
