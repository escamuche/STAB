package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class CriticalMastery_Feat extends CombatFeat{
	
	public static final String ID="CRITICALMASTERY_FEAT";

	
	
	public CriticalMastery_Feat() {
		
		this.addRequiredTrait(CriticalFocus_Feat.ID);
		//this.addRequiredTrait(any 2 critical feats...);
		//this.addRequiredAttribute(fighter, 14);
	}
	
}