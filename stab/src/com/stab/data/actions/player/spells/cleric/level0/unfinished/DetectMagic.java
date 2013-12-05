package com.stab.data.actions.player.spells.cleric.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;


public class DetectMagic extends SpellOnSelf{
	public static final String ID="DETECTMAGIC_CLERIC";

	public DetectMagic() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.CLERICCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("DetectMagic");
	     this.setEffectType(BUFF);
		}



	
}