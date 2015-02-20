package com.stab.pf.info.feat.combat;

import com.stab.pf.info.feat.MetamagicFeat;

public class FarShot_Feat extends MetamagicFeat{
	
	public static final String ID="FARSHOT_FEAT";

	
	
	public FarShot_Feat() {
			
		this.addRequiredTrait(PointBlankShot_Feat.ID);
	
	}
	
}