package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class DeadlyAim_Feat extends CombatFeat{
	
	public static final String ID="DEADLYAIM_FEAT";

	
	
	public DeadlyAim_Feat() {
		this.addRequiredAttribute(StabConstants.DEXTERITY, 13);
		this.addRequiredAttribute(StabConstants.BAB, 1);
			}
	
}
