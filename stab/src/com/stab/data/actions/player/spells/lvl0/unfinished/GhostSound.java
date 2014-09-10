package com.stab.data.actions.player.spells.lvl0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;

public class GhostSound extends SpellOnTile{

	public static final String ID="GHOSTSOUND";
	
	public GhostSound() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(6);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("GhostSound");
	     this.setEffectType(SPECIAL);
		}


	
}