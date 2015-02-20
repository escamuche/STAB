package com.stab.pf.info.feat.general;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class Toughness_Feat extends CombatFeat{
	
	public static final String ID="TOUGHNESS_FEAT";

	
	
	public Toughness_Feat() {
			
		Modifier hps = new Modifier(StabConstants.MAXHP, +3);
		this.addTrait(hps);
	
	}
	
}