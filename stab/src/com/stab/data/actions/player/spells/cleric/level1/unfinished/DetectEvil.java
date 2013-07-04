package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DetectEvil extends SpellOnSelf{
	
	public static final String ID="DETECTEVIL";

	
	public DetectEvil() {
     setRange(1);
     setResource("actions/bless");
     setName("Detect Evil");
     this.setEffectType(SPECIAL);
	}




	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}