package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.cleric.level1.unfinished.ProtectionChaos;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class ProtectionChaos_Wizard extends ProtectionChaos{
	
	public static final String ID="PROTECTIONCHAOS_WIZARD";
	
	public ProtectionChaos_Wizard() {
		
		setCasterClass(StabConstants.WIZARDCASTER);
		
	}
}
