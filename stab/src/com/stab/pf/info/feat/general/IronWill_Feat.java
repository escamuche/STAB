package com.stab.pf.info.feat.general;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.Feat;

public class IronWill_Feat extends Feat{
	
	public static final String ID="IRONWILL_FEAT";

	
	
	public IronWill_Feat() {
		
			Modifier buff=new Modifier(StabConstants.WILLSAVE,+2);
			addTrait(buff);
		
			}
	
}

