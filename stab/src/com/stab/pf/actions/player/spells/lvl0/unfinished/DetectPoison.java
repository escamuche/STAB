package com.stab.pf.actions.player.spells.lvl0.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnSelf;


public class DetectPoison extends SpellOnSelf{
	public static final String ID="DETECTPOISON_CLERIC";

	public DetectPoison() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("DetectPoison");
	     this.setEffectType(BUFF);
		}



	
}
