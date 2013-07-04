package com.stab.data.actions.player.spells.wizard.level0.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.BaseInfo;
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


	
}
