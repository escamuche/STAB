package com.stab.pf.actions.player.spells.wizard.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTarget;

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



}

