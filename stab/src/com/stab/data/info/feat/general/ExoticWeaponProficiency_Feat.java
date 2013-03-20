package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;

public class ExoticWeaponProficiency_Feat extends WeaponProficiency_Feat{
	
	public static final String ID="EXOTICWEAPONPROFICIENCY_FEAT";

	
	
	public ExoticWeaponProficiency_Feat(String arma) {
		
		super(arma);
		
		this.addRequiredValue(StabConstants.BAB, 1);
		
			}
	
}

