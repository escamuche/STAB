package com.stab.pf.actions.player.spells.wizard.level1.unfinished;

import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTile;

public class UnseenServant extends SpellOnTile{

	public static final String ID="UNSEENSERVANT";
	
	public UnseenServant() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(6);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("UnseenServant");
	     this.setEffectType(SPECIAL);
		}



}