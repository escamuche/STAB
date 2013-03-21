package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class Toughness_Feat extends CombatFeat{
	
	public static final String ID="TOUGHNESS_FEAT";

	
	
	public Toughness_Feat() {
			
		Modifier hps = new Modifier(StabConstants.MAXHP, +3);
		this.addTrait(hps);
	
	}
	
}