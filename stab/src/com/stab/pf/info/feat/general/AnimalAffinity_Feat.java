package com.stab.pf.info.feat.general;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.Feat;

public class AnimalAffinity_Feat extends Feat{
	
	public static final String ID="ANIMALAFFINITY_FEAT";

	
	
	public AnimalAffinity_Feat() {
		
			Modifier buff1=new Modifier(StabConstants.HANDLEANIMAL,+2);
			Modifier buff2=new Modifier(StabConstants.RIDE,+2);
			addTrait(buff1);
			addTrait(buff2);
		
			}
	
}
