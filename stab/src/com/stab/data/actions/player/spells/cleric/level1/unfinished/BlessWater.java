package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class BlessWater extends TargetAction{
	
	public static final String ID="BLESSWATER";

	
	public BlessWater() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/bless");
     setName("Bless Water");
     this.setEffectType(SPECIAL);
	}


	@Override
	public boolean affect(Info instigator,Info receive) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		return false;
	}

	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}