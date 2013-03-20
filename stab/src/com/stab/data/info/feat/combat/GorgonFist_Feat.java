package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;

public class GorgonFist_Feat extends CombatFeat{
	
	public static final String ID="GORGONFIST_FEAT";

	
	
	public GorgonFist_Feat() {
			
		this.addRequiredTrait(ImprovedUnarmedStrike_Feat.ID);
		this.addRequiredTrait(ScorpionStyle_Feat.ID);
		this.addRequiredAttribute(StabConstants.BAB, 6);
		
	}
	
}