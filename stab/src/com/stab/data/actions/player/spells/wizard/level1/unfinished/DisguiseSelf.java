package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;

public class DisguiseSelf extends SpellOnSelf{
	
	public static final String ID="DISGUISESELF";
	
	public DisguiseSelf() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setResource("actions/ability_druid_naturalperfection");
     setName("DisguiseSelf");
     this.setEffectType(BUFF);
	}


}
