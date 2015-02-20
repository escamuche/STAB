package com.stab.pf.actions.player.spells.cleric.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTarget;

public class HideUndeads extends SpellOnTarget{
	
	public static final String ID="HIDEUNDEADS";



	
	public HideUndeads() {
     setRange(1);
     
     setResource("actions/curelightwounds");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("CureLight");
     this.setEffectType(HEAL);
	}
}