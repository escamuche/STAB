package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;

public class Cleave_Feat extends CombatFeat{
	
	public static final String ID="CLEAVE_FEAT";

	
	
	public Cleave_Feat() {
		this.addRequiredTrait(PowerAttack_Feat.ID);
		this.addRequiredAttribute(StabConstants.STRENGHT, 13);
		this.addRequiredAttribute(StabConstants.BAB, 1);
			}
	
}