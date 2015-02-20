package com.stab.pf.info.feat.combat;

import com.stab.pf.info.feat.CombatFeat;

public class ScorpionStyle_Feat extends CombatFeat{
	
	public static final String ID="SCORPIONSTYLE_FEAT";

	
	
	public ScorpionStyle_Feat() {
			
		this.addRequiredTrait(ImprovedUnarmedStrike_Feat.ID);
		
	}
	
}