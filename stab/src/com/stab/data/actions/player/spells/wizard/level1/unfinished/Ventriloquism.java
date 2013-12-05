package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;

public class Ventriloquism extends SpellOnTile{

	public static final String ID="VENTRILOQUISM";
	
	public Ventriloquism() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(CLOSE);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Ventriloquism");
	     this.setEffectType(SPECIAL);
		}



}
