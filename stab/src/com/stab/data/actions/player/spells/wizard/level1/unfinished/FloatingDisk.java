package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;

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