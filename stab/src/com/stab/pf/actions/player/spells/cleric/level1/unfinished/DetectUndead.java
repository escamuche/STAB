package com.stab.pf.actions.player.spells.cleric.level1.unfinished;

import com.stab.pf.actions.player.spells.SpellOnSelf;

public class DetectUndead extends SpellOnSelf{
	
	public static final String ID="DETECTUNDEAD";

	
	public DetectUndead() {
     setRange(1);
     setResource("actions/bless");
     setName("Detect Undead");
     this.setEffectType(SPECIAL);
	}




	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}