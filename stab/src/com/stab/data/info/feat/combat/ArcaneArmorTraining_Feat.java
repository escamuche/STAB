package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.data.info.feat.general.LightArmorProficiency_Feat;
import com.stab.model.info.trait.Modifier;

public class ArcaneArmorTraining_Feat extends CombatFeat{
	
	public static final String ID="ARCANEARMORTRAINING_FEAT";

	
	
	public ArcaneArmorTraining_Feat() {
		this.addRequiredTrait(LightArmorProficiency_Feat.ID);
			}
	
}