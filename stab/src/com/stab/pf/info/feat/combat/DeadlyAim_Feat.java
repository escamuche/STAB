package com.stab.pf.info.feat.combat;

import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class DeadlyAim_Feat extends CombatFeat{
	
	public static final String ID="DEADLYAIM_FEAT";

	
	
	public DeadlyAim_Feat() {
		this.addRequiredAttribute(StabConstants.DEXTERITY, 13);
		this.addRequiredAttribute(StabConstants.BAB, 1);
			}
	
}
