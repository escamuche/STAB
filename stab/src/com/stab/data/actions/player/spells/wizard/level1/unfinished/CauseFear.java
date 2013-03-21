package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class CauseFear extends SpellOnTarget{
	
	public static final String ID="CAUSEFEAR_WIZARD";

	@Override
	public boolean execute(Info yo, Info target) {
		return false;
		}
	
	public CauseFear() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/causefear");
     setName("CauseFear");
     this.setEffectType(DEBUFF);
	}
}