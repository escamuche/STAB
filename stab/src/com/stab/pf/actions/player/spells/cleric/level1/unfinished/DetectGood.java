package com.stab.pf.actions.player.spells.cleric.level1.unfinished;

import com.stab.pf.actions.player.spells.SpellOnSelf;

public class DetectGood extends SpellOnSelf{
	
	public static final String ID="DETECTGOOD";

	
	public DetectGood() {
     setRange(1);
     setResource("actions/bless");
     setName("Detect Good");
     this.setEffectType(SPECIAL);
	}


	
	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}
