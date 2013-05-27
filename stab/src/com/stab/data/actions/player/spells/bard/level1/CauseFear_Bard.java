package com.stab.data.actions.player.spells.bard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level1.unfinished.CauseFear;

public class CauseFear_Bard extends CauseFear{

	public static final String ID="CAUSEFEAR_BARD";
	
	public CauseFear_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}
