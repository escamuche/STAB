package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DetectLaw extends SelfAction{
	
	public static final String ID="DETECTLAW";

	
	public DetectLaw() {
     setRange(1);
     setResource("actions/bless");
     setName("Detect Law");
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
		return da�obase;
	}*/
	

}
