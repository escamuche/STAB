package com.stab.data.info.feat.general;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.Feat;

public class SelectiveChanneling_Feat extends Feat{
	
	public static final String ID="SELECTIVECHANNELING_FEAT";

	
	
	public SelectiveChanneling_Feat() {
	
		this.addRequiredAttribute(StabConstants.CHARISMA, 13);
		//this.addRequiredTrait(ChannelEnergyAbility.ID);
		
	}
	
}
