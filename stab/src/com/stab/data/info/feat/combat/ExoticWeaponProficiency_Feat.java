package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;

public class ExoticWeaponProficiency_Feat extends CombatFeat{
	
	public static final String ID="EXOTICWEAPONPROFICIENCY_FEAT";

	
	
	public ExoticWeaponProficiency_Feat() {
		
		this.addRequiredAttribute(StabConstants.BAB, 1);
		
			}
	
}