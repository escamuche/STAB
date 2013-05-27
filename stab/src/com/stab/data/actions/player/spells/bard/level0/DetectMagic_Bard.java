package com.stab.data.actions.player.spells.bard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level0.unfinished.DetectMagic;

public class DetectMagic_Bard extends DetectMagic{

	public static final String ID="DETECTMAGIC_BARD";
	
	public DetectMagic_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}
