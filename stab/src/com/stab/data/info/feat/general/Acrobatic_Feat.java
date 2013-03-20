package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class Acrobatic_Feat extends Feat{
	
	public static final String ID="ACROBATIC_FEAT";

	
	
	public Acrobatic_Feat() {
		
			Modifier buff1=new Modifier(StabConstants.ACROBATICS,+2);
			Modifier buff2=new Modifier(StabConstants.FLYSKILL,+2);
			addTrait(buff1);
			addTrait(buff2);
		
			}
	
}