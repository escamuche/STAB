package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;

public class Sleep extends SpellOnTile{

	public static final String ID="SLEEP";
	
	public Sleep() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(22);
	     setResource("actions/sleep");
	     setName("Sleep");
	     this.setEffectType(DEBUFF);
		}


	
}
