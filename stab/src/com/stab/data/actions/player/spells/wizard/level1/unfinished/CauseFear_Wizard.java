package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level1.unfinished.CauseFear;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class CauseFear_Wizard extends CauseFear{
	
	public static final String ID="CAUSEFEAR_WIZARD";
	
	public CauseFear_Wizard() {
	
		setCasterClass(StabConstants.WIZARDCASTER);
		
	}
}