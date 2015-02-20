package com.stab.pf.info.feat.general;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.Feat;

public class Deceitful_Feat extends Feat{
	
	public static final String ID="DECEITFUL_FEAT";

	
	
	public Deceitful_Feat() {
		
		Modifier buff1=new Modifier(StabConstants.BLUFF,+2);
		Modifier buff2=new Modifier(StabConstants.DISGUISE,+2);
		addTrait(buff1);
		addTrait(buff2);
		
			}
	
}
