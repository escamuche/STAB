package com.stab.data.info.buff.spells;

import com.stab.model.info.trait.Trait;
import com.stab.model.info.trait.base.Buff;

public class LightInUse extends Trait {
	
	Buff buff = null;
	public static String ID="LIGHTINUSE";
	
	public void setBuff(Buff buff) {
		this.buff = buff;
	}
	
	public Buff getBuff() {
		return buff;
	}
}
