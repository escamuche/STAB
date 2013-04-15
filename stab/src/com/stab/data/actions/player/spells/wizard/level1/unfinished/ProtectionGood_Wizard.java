package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level1.unfinished.ProtectionGood;
import com.stab.model.basic.token.PhysicalToken;

public class ProtectionGood_Wizard extends ProtectionGood {
	
	public static final String ID="PROTECTIONGOOD_WIZARD";

	
	public ProtectionGood_Wizard() {
		
		setCasterClass(StabConstants.WIZARDCASTER);
	
	}
}
