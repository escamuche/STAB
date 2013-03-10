package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class CurseWater extends TargetAction{
	
	public static final String ID="CURSEWATER";

	
	public CurseWater() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/bless");
     setName("Curse Water");
     this.setEffectType(SPECIAL);
	}


	@Override
	public boolean execute(Info arg0, Info arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}
