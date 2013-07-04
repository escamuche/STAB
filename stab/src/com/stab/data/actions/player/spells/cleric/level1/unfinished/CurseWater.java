package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

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
