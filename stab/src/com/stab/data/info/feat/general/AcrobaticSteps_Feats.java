package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class AcrobaticSteps_Feats extends Feat{
	
	public static final String ID="ACROBATICSTEPS_FEAT";

	
	
	public AcrobaticSteps_Feats() {
		this.addRequiredAttribute(StabConstants.DEXTERITY, 15);
		this.addRequiredTrait(NimbleMoves_Feat.ID);
			}
	
}