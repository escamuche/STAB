package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class BlessWater extends SpellOnSelf{
	
	public static final String ID="BLESSWATER";

	
	public BlessWater() {
     setRange(1);
      setResource("actions/bless");
     setName("Bless Water");
     this.setEffectType(SPECIAL);
	}

	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 3;
	}
	

}