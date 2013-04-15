package com.stab.data.actions.player.spells.bard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.wizard.level1.unfinished.DetectSecretDoors;

public class DetectSecretDoors_Bard extends DetectSecretDoors{

	public static final String ID="DETECTSECRETDOORS_BARD";
	
	DetectSecretDoors_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}
