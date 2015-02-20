package com.stab.pf.info.feat.general;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.Feat;

public class DeftHands_Feat extends Feat{
	
	public static final String ID="DEFTHANDS_FEAT";

	
	
	public DeftHands_Feat() {
		
			Modifier buff1=new Modifier(StabConstants.DISABLEDEVICES,+2);
			Modifier buff2=new Modifier(StabConstants.SLEIGHTOFHAND,+2);
			addTrait(buff1);
			addTrait(buff2);
		
			}
	
}