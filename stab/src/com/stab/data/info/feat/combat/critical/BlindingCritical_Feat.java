package com.stab.data.info.feat.combat.critical;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.data.info.feat.combat.CriticalFocus_Feat;
import com.stab.model.info.trait.Modifier;

public class BlindingCritical_Feat extends CombatFeat{
	
	public static final String ID="BLINDINGCRITICAL_FEAT";

	
	
	public BlindingCritical_Feat() {
		this.addRequiredTrait(CriticalFocus_Feat.ID);
			}
	
}