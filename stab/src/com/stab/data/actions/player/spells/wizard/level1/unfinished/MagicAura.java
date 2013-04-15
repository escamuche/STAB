package com.stab.data.actions.player.spells.wizard.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.Info;

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