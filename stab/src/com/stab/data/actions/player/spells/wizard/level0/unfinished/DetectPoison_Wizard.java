package com.stab.data.actions.player.spells.wizard.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level0.unfinished.DetectPoison;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;


public class DetectPoison_Wizard extends DetectPoison{
	
	public static final String ID="DETECTPOISON_WIZARD";

	public DetectPoison_Wizard() {
	     
		 setCasterClass(StabConstants.WIZARDCASTER);
	 
		}

}
