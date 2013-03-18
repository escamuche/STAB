package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class HeavyArmorProficiency_Feat extends Feat{
	
	public static final String ID="HEAVYARMORPROFICIENCY_FEAT";

	
	
	public HeavyArmorProficiency_Feat() {
		this.addRequiredTrait(MediumArmorProficiency_Feat.ID);
		this.addRequiredTrait(LightArmorProficiency_Feat.ID);
			}
	
}