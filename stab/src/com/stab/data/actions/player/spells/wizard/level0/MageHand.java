package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.interfaces.Interactive;
import com.stab.model.info.Info;

public class MageHand extends SpellOnTarget{

	public static final String ID="MAGEHAND";
	
	public MageHand() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(6);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("MageHand");
	     this.setEffectType(SPECIAL);
		}


	@Override
	public boolean execute(Info target, Info yo) {
		
		Interactive Atacado = (Interactive)target;
		Atacado.infoInteracts(yo);
		return true;
	}
}