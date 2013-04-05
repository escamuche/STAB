package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
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
	public boolean affect(Info instigator, Info receptor) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		return false;
	}


	

	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}
