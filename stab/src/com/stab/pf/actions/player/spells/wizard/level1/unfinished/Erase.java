package com.stab.pf.actions.player.spells.wizard.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTarget;

public class Erase extends SpellOnTarget{
	
	public static final String ID="ERASE";


	
	public Erase() {
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setRange(6);
     
     setResource("actions/ability_shaman_watershield");
     setName("Erase");
     this.setEffectType(DEBUFF);
	}
}
