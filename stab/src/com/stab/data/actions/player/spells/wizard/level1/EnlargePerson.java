package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.Info;

public class EnlargePerson extends SpellOnTarget {
	
	public static final String ID="ENLARGEPERSON";
	
	public EnlargePerson() {
		setLevel(1);
		 setRange(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setResource("actions/ability_druid_naturalperfection");
     setName("EnlargePerson");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean execute(Info arg0, Info arg1) {
		// falta EnlargePerson_buff
		return false;
	}
}
