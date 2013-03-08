package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.EnlargePerson_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class EnlargePerson extends SpellOnTarget {
	
	public static final String ID="ENLARGEPERSON";
	
	public EnlargePerson() {
		setLevel(1);
		 setRange(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setResource("actions/enlargeperson");
     setName("EnlargePerson");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo buffed= (BaseInfo) target;
		EnlargePerson_Buff buff = new EnlargePerson_Buff(buffed);
		buffed.addTrait(buff);
		return true;
	}
}
