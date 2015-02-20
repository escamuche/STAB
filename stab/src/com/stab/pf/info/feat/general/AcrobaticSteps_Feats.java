package com.stab.pf.info.feat.general;

import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.Feat;

public class AcrobaticSteps_Feats extends Feat{
	
	public static final String ID="ACROBATICSTEPS_FEAT";

	
	
	public AcrobaticSteps_Feats() {
		this.addRequiredAttribute(StabConstants.DEXTERITY, 15);
		this.addRequiredTrait(NimbleMoves_Feat.ID);
			}
	
}