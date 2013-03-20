package com.stab.data.info.feat.combat.critical;

import com.stab.data.info.feat.CombatFeat;
import com.stab.data.info.feat.combat.CriticalFocus_Feat;

public class DeafeningCritical_Feat extends CombatFeat{
	
	public static final String ID="DEAFENINGCRITICAL_FEAT";

	
	
	public DeafeningCritical_Feat() {
		this.addRequiredTrait(CriticalFocus_Feat.ID);
			}
	
}