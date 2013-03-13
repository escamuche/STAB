package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class MediumArmorProficiency_Feat extends Feat{
	
	public static final String ID="MEDIUMARMORPROFICIENCY_FEAT";

	
	
	public MediumArmorProficiency_Feat() {
		this.addRequiredTrait(LightArmorProficiency_Feat.ID);
			}
	
}