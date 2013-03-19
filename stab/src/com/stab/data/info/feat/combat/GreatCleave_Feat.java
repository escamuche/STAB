package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class GreatCleave_Feat extends CombatFeat{
	
	public static final String ID="GREATCLEAVE_FEAT";

	
	
	public GreatCleave_Feat() {
			
		this.addRequiredTrait(Cleave_Feat.ID);
		this.addRequiredTrait(PowerAttack_Feat.ID);
		this.addRequiredAttribute(StabConstants.BAB, 4);
		this.addRequiredAttribute(StabConstants.STRENGHT, 13);
		
	}
	
}