package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.Info;

public class Bleed extends SpellOnTarget{
	
	public static final String ID="BLEED";

	public Bleed() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(6);
	     setTargetClass(PhysicalToken.class);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("AcidSplash");
	     this.setEffectType(DEBUFF);
		}

	@Override
	public boolean execute(Info arg0, Info arg1) {
		// TODO Auto-generated method stub
		return false;
	}
}
