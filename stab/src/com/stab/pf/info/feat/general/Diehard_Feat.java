package com.stab.pf.info.feat.general;

import com.stab.pf.info.feat.Feat;

public class Diehard_Feat extends Feat{
	
	public static final String ID="DIEHARD_FEAT";

	
	
	public Diehard_Feat() {
		this.addRequiredTrait(Endurance_Feat.ID);
			}
	
}