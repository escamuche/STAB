package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class ImprovedInitiative_Feat extends Feat{
	
	public static final String ID="IMPROVEDINITIATIVE_FEAT";

	
	
	public ImprovedInitiative_Feat() {
		
			Modifier buff=Modifier.createMod(StabConstants.INICIATIVEMOD,+4);
			addTrait(buff);
		
			}
	
}
