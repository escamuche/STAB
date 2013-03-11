package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class ProtectionChaos extends SpellOnTarget{
	
	public static final String ID="PROTECTIONCHAOS_CLERIC";

	@Override
	public boolean execute(Info yo, Info target) {
		return false;
		}
	
	public ProtectionChaos() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_shaman_watershield");
     setName("Protection Chaos");
     this.setEffectType(BUFF);
	}
}
