package com.stab.pf.info.feat.general;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.Feat;

public class ImprovedInitiative_Feat extends Feat{
	
	public static final String ID="IMPROVEDINITIATIVE_FEAT";

	
	
	public ImprovedInitiative_Feat() {
		
			Modifier buff=new Modifier(StabConstants.INICIATIVEMOD,+4);
			addTrait(buff);
		
			}
	
}
