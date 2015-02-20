package com.stab.pf.actions.player.spells.wizard.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTarget;

public class MagicAura extends SpellOnTarget{

	public static final String ID="MAGICAURA";
	
	public MagicAura() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(6);
	     setResource("actions/hypnotism");
	     setName("MagicAura");
	     this.setEffectType(DEBUFF);
		}

}