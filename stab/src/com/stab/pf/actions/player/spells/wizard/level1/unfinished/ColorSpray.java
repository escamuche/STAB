package com.stab.pf.actions.player.spells.wizard.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTile;

public class ColorSpray extends SpellOnTile{

	public static final String ID="COLORSPRAY";
	
	public ColorSpray() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(1);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("ColorSpray");
	     this.setEffectType(DEBUFF);
		}


	
}
