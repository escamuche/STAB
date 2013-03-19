package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class DeadlyStroke_Feat extends CombatFeat{
	
	public static final String ID="DEADLYSTROKE_FEAT";

	
	
	public DeadlyStroke_Feat() {
		this.addRequiredTrait(DazzlingDisplay_Feat.ID);
		this.addRequiredTrait(GreaterWeaponFocus_Feat.ID);
		this.addRequiredTrait(ShatterDefenses_Feat.ID);
		this.addRequiredTrait(WeaponFocus_Feat.ID);
		this.addRequiredAttribute(StabConstants.BAB, 11);
		//this.addRequiredTrait(pericia arma);
			}
	
}