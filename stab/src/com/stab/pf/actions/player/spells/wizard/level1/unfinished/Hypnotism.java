package com.stab.pf.actions.player.spells.wizard.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTile;

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
