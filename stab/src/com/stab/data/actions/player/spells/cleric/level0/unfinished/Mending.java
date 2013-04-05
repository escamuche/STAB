package com.stab.data.actions.player.spells.cleric.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Mending extends SpellOnTarget{
	
	public static final String ID="MENDING_CLERIC";

	@Override
	public boolean affect(Info instigator, Info receptor) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		return false;
	}
	
	public Mending() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
     setRange(2);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_druid_naturalperfection");
     setName("Mending");
     this.setEffectType(HEAL);
	}
}