package com.stab.pf.actions.player.spells.cleric.level1.unfinished;

import com.stab.pf.actions.player.spells.SpellOnSelf;

public class DetectLaw extends SpellOnSelf{
	
	public static final String ID="DETECTLAW";

	
	public DetectLaw() {
     setRange(1);
     setResource("actions/bless");
     setName("Detect Law");
     this.setEffectType(SPECIAL);
	}




	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}
