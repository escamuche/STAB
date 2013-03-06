package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.model.info.BaseInfo;

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
	public boolean execute(BaseInfo arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
