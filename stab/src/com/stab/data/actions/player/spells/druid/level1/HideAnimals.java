package com.stab.data.actions.player.spells.druid.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;

public class HideAnimals extends SpellOnTarget{
	
public static final String ID="HIDEANIMALS_DRUID";
	
	public HideAnimals(){
		
		setCasterClass(StabConstants.DRUIDCASTER);
		
	}
}