package com.stab.pf.actions.player.spells.cleric.level1.unfinished;

import com.stab.pf.actions.player.spells.SpellOnSelf;

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
		return da�obase;
	}*/
	

}