package com.stab.data.info.feat.combat.critical;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.data.info.feat.combat.CriticalFocus_Feat;
import com.stab.data.info.feat.general.MediumArmorProficiency_Feat;
import com.stab.model.info.trait.Modifier;

public class TiringCritical_Feat extends CombatFeat{
	
	public static final String ID="TIRINGCRITICAL_FEAT";

	
	
	public TiringCritical_Feat() {
		this.addRequiredTrait(CriticalFocus_Feat.ID);
		this.addRequiredAttribute(StabConstants.BAB, 13);
			}
	
}