package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DetectChaos extends SpellOnSelf{
	
	public static final String ID="DETECTCHAOS";

	
	public DetectChaos() {
     setRange(1);
     setResource("actions/bless");
     setName("Bless Water");
     this.setEffectType(SPECIAL);
	}


	

	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return da�obase;
	}*/
	

}
