package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;

public class Hypnotism extends SpellOnTile{

	public static final String ID="HYPNOTISM";
	
	public Hypnotism() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(6);
	     setResource("actions/hypnotism");
	     setName("Hypnotism");
	     this.setEffectType(DEBUFF);
		}



}
