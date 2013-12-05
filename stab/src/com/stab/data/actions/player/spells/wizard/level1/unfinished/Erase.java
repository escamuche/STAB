package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;

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
