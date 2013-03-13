package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class AugmentSummoning_Feat extends Feat{
	
	public static final String ID="AUGMENTSUMMONING_FEAT";

	
	
	public AugmentSummoning_Feat() {
		this.addRequiredTrait(SpellFocusConjuration_Feat.ID);
			}
	
}
