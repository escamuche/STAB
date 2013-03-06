package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.Info;

public class Jump extends SpellOnTarget {
	
	public static final String ID="JUMP";
	
	public Jump() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(1);
     setResource("actions/ability_druid_naturalperfection");
     setName("Jump");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean execute(Info arg0, Info arg1) {
		// falta EnlargePerson_buff
		return false;
	}


}
