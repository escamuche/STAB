package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class ProtectionEvil extends SpellOnTarget{
	
	public static final String ID="PROTECTIONEVIL";

	@Override
	public boolean execute(Info yo, Info target) {
		return false;
		}
	
	public ProtectionEvil() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/protectionevil");
     setName("ProtectionEvil");
     this.setEffectType(BUFF);
	}
}
