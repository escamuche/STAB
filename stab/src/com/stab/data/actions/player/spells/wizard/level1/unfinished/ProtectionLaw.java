package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class ProtectionLaw extends SpellOnTarget{
	
	public static final String ID="PROTECTIONLAW_WIZARD";

	@Override
	public boolean affect(Info instigator, Info receptor) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		return false;
		}
	
	public ProtectionLaw() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_shaman_watershield");
     setName("ProtectionLaw");
     this.setEffectType(BUFF);
	}
}