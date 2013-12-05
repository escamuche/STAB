package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;

public class ObscuringMist extends SpellOnTile{

	public static final String ID="OBSCURINGMIST_CLERIC";
	
	public ObscuringMist() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.CLERICCASTER);
		 setRange(4);
	     setResource("actions/obscuringmist");
	     setName("ObscuringMist");
	     this.setEffectType(SPECIAL);
		}



}
