package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class SummonMonster1 extends SpellOnTile{

	public static final String ID="SUMMONMONSTER1_CLERIC";
	
	public SummonMonster1() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.CLERICCASTER);
		 setRange(6);
	     setResource("actions/summonmonster1");
	     setName("SummonMonster1");
	     this.setEffectType(SPECIAL);
		}


	
}