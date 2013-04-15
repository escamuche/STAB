package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DetectGood extends SelfAction{
	
	public static final String ID="DETECTGOOD";

	
	public DetectGood() {
     setRange(1);
     setResource("actions/bless");
     setName("Detect Good");
     this.setEffectType(SPECIAL);
	}


	@Override
	public boolean affect(Info instigator, Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		return false;
	}

	
	/*@Override
	public int getEffectValue(BaseInfo i) {
		return dañobase;
	}*/
	

}
