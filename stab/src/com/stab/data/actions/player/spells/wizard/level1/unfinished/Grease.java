package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;

public class Grease extends SpellOnTile{

	public static final String ID="DANCINGLIGHTS";
	
	public Grease() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(6);
	     setResource("actions/grease");
	     setName("Grease");
	     this.setEffectType(SPECIAL);
		}


	
}