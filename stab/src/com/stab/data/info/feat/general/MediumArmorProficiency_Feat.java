package com.stab.data.info.feat.general;

import com.stab.data.info.feat.Feat;

public class MediumArmorProficiency_Feat extends Feat{
	
	public static final String ID="MEDIUMARMORPROFICIENCY_FEAT";

	
	
	public MediumArmorProficiency_Feat() {
		this.addRequiredTrait(LightArmorProficiency_Feat.ID);
			}
	
}