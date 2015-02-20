package com.stab.pf.actions.player.spells.wizard.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTile;

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