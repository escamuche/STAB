package com.stab.data.actions.player.spells.wizard.level0.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.Info;

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


	@Override
	public boolean execute(Info arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}
}
