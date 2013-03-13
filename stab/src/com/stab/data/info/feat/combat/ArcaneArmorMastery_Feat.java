package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class ArcaneArmorMastery_Feat extends CombatFeat{
	
	public static final String ID="ARCANEARMORMASTERY_FEAT";

	
	
	public ArcaneArmorMastery_Feat() {
		this.addRequiredTrait(ArcaneArmorTraining_Feat.ID);
			}
	
}
