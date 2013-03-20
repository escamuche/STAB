package com.stab.data.info.feat.combat.critical;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.data.info.feat.combat.CriticalFocus_Feat;

public class TiringCritical_Feat extends CombatFeat{
	
	public static final String ID="TIRINGCRITICAL_FEAT";

	
	
	public TiringCritical_Feat() {
		this.addRequiredTrait(CriticalFocus_Feat.ID);
		this.addRequiredAttribute(StabConstants.BAB, 13);
			}
	
}