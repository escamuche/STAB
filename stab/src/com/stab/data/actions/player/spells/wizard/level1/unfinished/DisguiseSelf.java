package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DisguiseSelf extends SpellOnSelf{
	
	public static final String ID="DISGUISESELF";
	
	public DisguiseSelf() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setResource("actions/ability_druid_naturalperfection");
     setName("DisguiseSelf");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean affect(Info instigator,Info receive) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		return false;
	}
}
