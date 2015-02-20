package com.stab.pf.actions.player.spells.wizard.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTile;

public class AnimateRope extends SpellOnTile{

	public static final String ID="ANIMATEROPE";
	
	public AnimateRope() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(MEDIUM);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Animate Rope");
	     this.setEffectType(DEBUFF);
		}


	
}