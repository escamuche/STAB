package com.stab.data.actions.player.spells.druid.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;

public class DetectAnimals extends SpellOnSelf{
	
public static final String ID="DETECTANIMALS_DRUID";
	
	public DetectAnimals(){
		
		setCasterClass(StabConstants.DRUIDCASTER);
		
	}
}
