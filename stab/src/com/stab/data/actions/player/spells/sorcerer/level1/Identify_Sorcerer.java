package com.stab.data.actions.player.spells.sorcerer.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.wizard.level1.Identify;

public class Identify_Sorcerer extends Identify {
	
public static final String ID="IDENTIFY_SORCERER";
	
	public Identify_Sorcerer(){
		
		setCasterClass(StabConstants.SORCERERCASTER);
		
	}
}
