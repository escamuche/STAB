package com.stab.data.actions.player.spells.bard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.wizard.level1.CharmPerson;

public class CharmPerson_Bard extends CharmPerson{

	public static final String ID="CHARMPERSON_BARD";
	
	public CharmPerson_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}
