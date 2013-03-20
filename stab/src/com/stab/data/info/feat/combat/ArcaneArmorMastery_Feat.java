package com.stab.data.info.feat.combat;

import com.stab.data.info.feat.CombatFeat;
import com.stab.data.info.feat.general.MediumArmorProficiency_Feat;

public class ArcaneArmorMastery_Feat extends CombatFeat{
	
	public static final String ID="ARCANEARMORMASTERY_FEAT";

	
	
	public ArcaneArmorMastery_Feat() {
		
		this.addRequiredTrait(ArcaneArmorTraining_Feat.ID);
		this.addRequiredTrait(MediumArmorProficiency_Feat.ID);
		//this.addRequiredAttribute(casterlevel=7);
	}
	
}
