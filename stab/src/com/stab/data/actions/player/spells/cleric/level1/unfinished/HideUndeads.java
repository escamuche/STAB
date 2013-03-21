package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class HideUndeads extends SpellOnTarget{
	
	public static final String ID="HIDEUNDEADS";


	@Override
	public boolean execute(Info yo, Info target) {
		return false;
		}
	
	public HideUndeads() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/curelightwounds");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("CureLight");
     this.setEffectType(HEAL);
	}
}