package com.stab.data.info.feat.combat.critical;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.data.info.feat.combat.CriticalFocus_Feat;
import com.stab.data.info.feat.general.MediumArmorProficiency_Feat;
import com.stab.model.info.trait.Modifier;

public class ExhaustingCritical_Feat extends CombatFeat{
	
	public static final String ID="EXHAUSTINGCRITICAL_FEAT";

	
	
	public ExhaustingCritical_Feat() {
		this.addRequiredTrait(CriticalFocus_Feat.ID);
		this.addRequiredAttribute(StabConstants.BAB,15);
		this.addRequiredTrait(TiringCritical_Feat.ID);
		
			}
	
}