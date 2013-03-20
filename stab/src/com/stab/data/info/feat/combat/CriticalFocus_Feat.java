package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;

public class CriticalFocus_Feat extends CombatFeat{
	
	public static final String ID="CRITICALFOCUS_FEAT";

	
	
	public CriticalFocus_Feat() {
		
		this.addRequiredAttribute(StabConstants.BAB, 9);
			 
	}
	
}
