package com.stab.pf.info.feat.combat;

import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class ExoticWeaponProficiency_Feat extends CombatFeat{
	
	public static final String ID="EXOTICWEAPONPROFICIENCY_FEAT";

	
	
	public ExoticWeaponProficiency_Feat() {
		
		this.addRequiredAttribute(StabConstants.BAB, 1);
		
			}
	
}