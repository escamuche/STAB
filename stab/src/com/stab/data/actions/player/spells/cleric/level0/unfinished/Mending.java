package com.stab.data.actions.player.spells.cleric.level0.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Mending extends SpellOnTarget{
	
	public static final String ID="MENDING_CLERIC";


	
	public Mending() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
     setRange(2);
     
     setResource("actions/ability_druid_naturalperfection");
     setName("Mending");
     this.setEffectType(HEAL);
	}
}