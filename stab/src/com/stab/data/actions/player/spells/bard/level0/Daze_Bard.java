package com.stab.data.actions.player.spells.bard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.wizard.level0.Daze;

public class Daze_Bard extends Daze{

	public static final String ID="DAZE_BARD";
	
	Daze_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}