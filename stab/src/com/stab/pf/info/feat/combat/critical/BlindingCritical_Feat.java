package com.stab.pf.info.feat.combat.critical;

import com.stab.pf.info.feat.CombatFeat;
import com.stab.pf.info.feat.combat.CriticalFocus_Feat;

public class BlindingCritical_Feat extends CombatFeat{
	
	public static final String ID="BLINDINGCRITICAL_FEAT";

	
	
	public BlindingCritical_Feat() {
		this.addRequiredTrait(CriticalFocus_Feat.ID);
		//this.addRequiredTrait(bab,15);
			}
	
}