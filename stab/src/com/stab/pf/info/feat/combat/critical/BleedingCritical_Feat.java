package com.stab.pf.info.feat.combat.critical;

import com.stab.pf.info.feat.CombatFeat;
import com.stab.pf.info.feat.combat.CriticalFocus_Feat;

public class BleedingCritical_Feat extends CombatFeat{
	
	public static final String ID="BLEEDINGCRITICAL_FEAT";

	
	
	public BleedingCritical_Feat() {
		this.addRequiredTrait(CriticalFocus_Feat.ID);
		//this.addRequiredTrait(bab,11);
			}
	
}