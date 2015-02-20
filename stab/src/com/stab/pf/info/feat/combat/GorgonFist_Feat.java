package com.stab.pf.info.feat.combat;

import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class GorgonFist_Feat extends CombatFeat{
	
	public static final String ID="GORGONFIST_FEAT";

	
	
	public GorgonFist_Feat() {
			
		this.addRequiredTrait(ImprovedUnarmedStrike_Feat.ID);
		this.addRequiredTrait(ScorpionStyle_Feat.ID);
		this.addRequiredAttribute(StabConstants.BAB, 6);
		
	}
	
}