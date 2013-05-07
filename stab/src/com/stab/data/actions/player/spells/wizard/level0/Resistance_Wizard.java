package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level0.Resistance;

public class Resistance_Wizard extends Resistance{
	
	public static final String ID="RESISTANCE_WIZARD";

	
	public Resistance_Wizard() {
		
		setCasterClass(StabConstants.WIZARDCASTER);
		
	}
}