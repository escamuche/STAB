package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class DeftHands_Feat extends Feat{
	
	public static final String ID="DEFTHANDS_FEAT";

	
	
	public DeftHands_Feat() {
		
			Modifier buff1=new Modifier(StabConstants.DISABLEDEVICES,+2);
			Modifier buff2=new Modifier(StabConstants.SLEIGHTOFHAND,+2);
			addTrait(buff1);
			addTrait(buff2);
		
			}
	
}