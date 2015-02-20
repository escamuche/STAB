package com.stab.pf.info.feat.general;

import com.stab.pf.info.feat.Feat;

public class HeavyArmorProficiency_Feat extends Feat{
	
	public static final String ID="HEAVYARMORPROFICIENCY_FEAT";

	
	
	public HeavyArmorProficiency_Feat() {
		this.addRequiredTrait(MediumArmorProficiency_Feat.ID);
		this.addRequiredTrait(LightArmorProficiency_Feat.ID);
			}
	
}