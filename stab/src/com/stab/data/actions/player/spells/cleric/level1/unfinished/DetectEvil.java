package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;

public class DetectEvil extends SelfAction{
	
	public static final String ID="DETECTEVIL";

	
	public DetectEvil() {
     setRange(1);
     setResource("actions/bless");
     setName("Detect Evil");
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