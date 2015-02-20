package com.stab.pf.info.feat.combat.critical;

import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;
import com.stab.pf.info.feat.combat.CriticalFocus_Feat;

public class ExhaustingCritical_Feat extends CombatFeat{
	
	public static final String ID="EXHAUSTINGCRITICAL_FEAT";

	
	
	public ExhaustingCritical_Feat() {
		this.addRequiredTrait(CriticalFocus_Feat.ID);
		this.addRequiredAttribute(StabConstants.BAB,15);
		this.addRequiredTrait(TiringCritical_Feat.ID);
		
			}
	
}