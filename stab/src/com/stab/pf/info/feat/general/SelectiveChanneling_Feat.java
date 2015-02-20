package com.stab.pf.info.feat.general;

import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.Feat;

public class SelectiveChanneling_Feat extends Feat{
	
	public static final String ID="SELECTIVECHANNELING_FEAT";

	
	
	public SelectiveChanneling_Feat() {
	
		this.addRequiredAttribute(StabConstants.CHARISMA, 13);
		//this.addRequiredTrait(ChannelPositiveEnergy.ID);		//TODO: revisar, hay que agrupar los channel
		
	}
	
}
