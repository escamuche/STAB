package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;
import com.stab.model.info.trait.Modifier;

public class IronWill_Feat extends Feat{
	
	public static final String ID="IRONWILL_FEAT";

	
	
	public IronWill_Feat() {
		
			Modifier buff=new Modifier(StabConstants.WILLSAVE,+2);
			addTrait(buff);
		
			}
	
}

