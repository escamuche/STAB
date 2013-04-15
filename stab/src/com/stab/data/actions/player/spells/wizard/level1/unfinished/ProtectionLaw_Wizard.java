package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level1.unfinished.ProtectionLaw;
import com.stab.model.basic.token.PhysicalToken;

public class ProtectionLaw_Wizard extends ProtectionLaw{
	
	public static final String ID="PROTECTIONLAW_WIZARD";
	
	public ProtectionLaw_Wizard() {
	
		setCasterClass(StabConstants.WIZARDCASTER);
		
	}
}