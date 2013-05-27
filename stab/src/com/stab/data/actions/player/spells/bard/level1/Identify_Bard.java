package com.stab.data.actions.player.spells.bard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.wizard.level1.Identify;

public class Identify_Bard extends Identify{

	public static final String ID="IDENTIFY_BARD";
	
	public Identify_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}