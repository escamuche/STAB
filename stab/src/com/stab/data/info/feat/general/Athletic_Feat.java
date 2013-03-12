package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class Athletic_Feat extends Feat{
	
	public static final String ID="ATHLETIC_FEAT";

	
	
	public Athletic_Feat() {
		
			Modifier buff1=Modifier.createMod(StabConstants.CLIMB,+2);
			Modifier buff2=Modifier.createMod(StabConstants.SWIMSKILL,+2);
			addTrait(buff1);
			addTrait(buff2);
		
			}
	
}
