package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;

public class DetectLaw extends SelfAction{
	
	public static final String ID="DETECTLAW";

	
	public DetectLaw() {
     setRange(1);
     setResource("actions/bless");
     setName("Detect Law");
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
