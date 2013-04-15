package com.stab.data.actions.player.spells.bard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level1.unfinished.RemoveFear;

public class RemoveFear_Bard extends RemoveFear{

	public static final String ID="REMOVEFEAR_BARD";
	
	RemoveFear_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}
