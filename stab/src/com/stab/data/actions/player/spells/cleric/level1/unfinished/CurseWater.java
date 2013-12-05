package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.actions.player.spells.SpellOnSelf;

public class CurseWater extends SpellOnSelf{
	
	public static final String ID="CURSEWATER";

	
	public CurseWater() {
     setRange(1);
     
     setResource("actions/bless");
     setName("Curse Water");
     this.setEffectType(SPECIAL);
	}


	

	

	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}
