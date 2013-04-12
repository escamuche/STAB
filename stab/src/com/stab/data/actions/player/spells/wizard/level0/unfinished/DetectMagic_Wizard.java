package com.stab.data.actions.player.spells.wizard.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level0.unfinished.DetectMagic;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;


public class DetectMagic_Wizard extends DetectMagic {
	
	public static final String ID="DETECTMAGIC_WIZARD";

	public DetectMagic_Wizard() {
	     
		 setCasterClass(StabConstants.WIZARDCASTER);
		}

}