package com.stab.data.actions.player.spells.bard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;

public class UndetectableAlignment extends SpellOnTarget{

	public static final String ID="UNDETECTABLEALIGNMENT";
	
	public UndetectableAlignment() {
		
		 setLevel(1);
		 setCasterClass(StabConstants.BARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setRange(CLOSE);
	     setName("Undetectable Alignment");
	     this.setEffectType(SPECIAL);
	     this.setDescription("An undetectable alignment spell conceals the alignment of an object or a creature from all forms of divination.");

		}


	
}
