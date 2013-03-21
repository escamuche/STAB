package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;

public class DetectUndead extends SpellOnSelf{
	
	public static final String ID="DETECTUNDEAD";

	
	public DetectUndead() {
     setRange(1);
     setResource("actions/bless");
     setName("Detect Undead");
     this.setEffectType(SPECIAL);
	}


	@Override
	public boolean execute(BaseInfo arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}