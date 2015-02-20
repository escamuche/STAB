package com.stab.pf.info.feat.general;

import com.stab.pf.info.feat.Feat;

public class AugmentSummoning_Feat extends Feat{
	
	public static final String ID="AUGMENTSUMMONING_FEAT";

	
	
	public AugmentSummoning_Feat() {
		this.addRequiredTrait(SpellFocusConjuration_Feat.ID);
			}
	
}
