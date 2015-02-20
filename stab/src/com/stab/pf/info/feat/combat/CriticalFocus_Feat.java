package com.stab.pf.info.feat.combat;

import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class CriticalFocus_Feat extends CombatFeat{
	
	public static final String ID="CRITICALFOCUS_FEAT";

	
	
	public CriticalFocus_Feat() {
		
		this.addRequiredAttribute(StabConstants.BAB, 9);
			 
	}
	
}
