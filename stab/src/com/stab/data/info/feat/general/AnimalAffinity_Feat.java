package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class AnimalAffinity_Feat extends Feat{
	
	public static final String ID="ANIMALAFFINITY_FEAT";

	
	
	public AnimalAffinity_Feat() {
		
			Modifier buff1=new Modifier(StabConstants.HANDLEANIMAL,+2);
			Modifier buff2=new Modifier(StabConstants.RIDE,+2);
			addTrait(buff1);
			addTrait(buff2);
		
			}
	
}
