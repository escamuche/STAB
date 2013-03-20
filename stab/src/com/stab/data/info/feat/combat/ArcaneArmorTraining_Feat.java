package com.stab.data.info.feat.combat;

import com.stab.data.info.feat.CombatFeat;
import com.stab.data.info.feat.general.LightArmorProficiency_Feat;

public class ArcaneArmorTraining_Feat extends CombatFeat{
	
	public static final String ID="ARCANEARMORTRAINING_FEAT";

	
	
	public ArcaneArmorTraining_Feat() {
		this.addRequiredTrait(LightArmorProficiency_Feat.ID);
		//this.addRequiredAttribute(caster lvl 3);
			}
	
}