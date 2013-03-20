package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class Alertness_Feat extends Feat{
	
	public static final String ID="ALERTNESS_FEAT";

	
	
	public Alertness_Feat() {
		
			Modifier buff1=new Modifier(StabConstants.PERCEPTION,+2);
			Modifier buff2=new Modifier(StabConstants.SENSEMOTIVE,+2);
			addTrait(buff1);
			addTrait(buff2);
		
			}
	
}
