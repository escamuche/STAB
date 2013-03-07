package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.Info;

public class FeatherFall extends SpellOnTarget{
	
	public static final String ID="FeatherFall";
	
	public FeatherFall() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setRange(1);
     setResource("actions/ability_druid_naturalperfection");
     setName("Identify");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean execute(Info arg0, Info arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}

