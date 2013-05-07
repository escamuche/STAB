package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DetectUndead extends SpellOnSelf{
	
	public static final String ID="DETECTUNDEAD";

	
	public DetectUndead() {
     setRange(1);
     setResource("actions/bless");
     setName("Detect Undead");
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
		return da�obase;
	}*/
	

}