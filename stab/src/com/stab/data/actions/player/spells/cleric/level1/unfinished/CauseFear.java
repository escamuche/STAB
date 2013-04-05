package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class CauseFear extends SpellOnTarget{
	
	public static final String ID="CAUSEFEAR_CLERIC";

	@Override
	public boolean affect(Info instigator, Info receptor) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		return false;
		}
	
	public CauseFear() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/causefear");
     setName("CauseFear");
     this.setEffectType(DEBUFF);
	}
}
