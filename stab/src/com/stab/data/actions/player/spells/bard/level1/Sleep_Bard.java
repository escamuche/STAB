package com.stab.data.actions.player.spells.bard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.wizard.level1.unfinished.Sleep;

public class Sleep_Bard extends Sleep{

	public static final String ID="SLEEP_BARD";
	
	public Sleep_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}
