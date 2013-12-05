package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.actions.player.spells.SpellOnSelf;

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
		return dañobase;
	}*/
	

}
