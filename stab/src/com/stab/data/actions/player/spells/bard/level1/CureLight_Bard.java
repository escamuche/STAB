package com.stab.data.actions.player.spells.bard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level1.CureLight;

public class CureLight_Bard extends CureLight{

	public static final String ID="CURELIGHT_BARD";
	
	CureLight_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}