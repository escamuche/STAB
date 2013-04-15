package com.stab.data.actions.player.spells.bard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level0.unfinished.DetectMagic;

public class Detectmagic_Bard extends DetectMagic{

	public static final String ID="DETECTMAGIC_BARD";
	
	Detectmagic_Bard() {
		 setCasterClass(StabConstants.BARDCASTER);
	}
}
