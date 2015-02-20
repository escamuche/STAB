package com.stab.pf.actions.player.spells.wizard.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTile;

public class FloatingDisk extends SpellOnTile{

	public static final String ID="FLOATINGDISK";
	
	public FloatingDisk() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(6);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("FloatingDisk");
	     this.setEffectType(SPECIAL);
		}


	
}