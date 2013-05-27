package com.stab.data.actions.player.spells.bard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level0.Resistance;

public class Resistance_Bard extends Resistance{

	public static final String ID="RESISTANCE_BARD";
	
	public Resistance_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}