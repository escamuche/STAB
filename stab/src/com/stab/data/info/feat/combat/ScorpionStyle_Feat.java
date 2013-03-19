package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class ScorpionStyle_Feat extends CombatFeat{
	
	public static final String ID="SCORPIONSTYLE_FEAT";

	
	
	public ScorpionStyle_Feat() {
			
		this.addRequiredTrait(ImprovedUnarmedStrike_Feat.ID);
		
	}
	
}