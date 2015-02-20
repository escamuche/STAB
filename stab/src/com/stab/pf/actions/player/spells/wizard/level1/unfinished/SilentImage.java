package com.stab.pf.actions.player.spells.wizard.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTile;

public class SilentImage extends SpellOnTile{

	public static final String ID="SILENTIMAGE";
	
	public SilentImage() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(88);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("SilentImage");
	     this.setEffectType(SPECIAL);
		}



}