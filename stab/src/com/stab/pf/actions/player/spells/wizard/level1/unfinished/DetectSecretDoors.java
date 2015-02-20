package com.stab.pf.actions.player.spells.wizard.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnSelf;


public class DetectSecretDoors extends SpellOnSelf{
	
	public static final String ID="DETECTSECRETDOORS";

	public DetectSecretDoors() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("DetectSecretDoors");
	     this.setEffectType(BUFF);
		}



	
}
