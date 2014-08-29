package com.stab.data.actions.player.spells.lvl0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;

public class Message extends SpellOnTile{

	public static final String ID="MESSAGE";
	
	public Message() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(22);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Message");
	     this.setEffectType(SPECIAL);
		}


	
}
