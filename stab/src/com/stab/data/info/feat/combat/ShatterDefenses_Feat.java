package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.action.BuffDebuffAction;
import com.stab.model.info.trait.Modifier;

public class ShatterDefenses_Feat extends CombatFeat{
	
	public static final String ID="SHATTERDEFENSES_FEAT";

	
	
	public ShatterDefenses_Feat() {
		this.addRequiredTrait(WeaponFocus_Feat.ID);
		this.addRequiredTrait(DazzlingDisplay_Feat.ID);
		this.addRequiredAttribute(StabConstants.BAB, 6);
		//this.addRequiredTrait(periciaarma);
			}
}