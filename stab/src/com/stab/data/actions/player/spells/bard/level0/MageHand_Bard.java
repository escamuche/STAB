package com.stab.data.actions.player.spells.bard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.wizard.level0.MageHand;

public class MageHand_Bard extends MageHand{

	public static final String ID="MAGEHAND_BARD";
	
	public MageHand_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}