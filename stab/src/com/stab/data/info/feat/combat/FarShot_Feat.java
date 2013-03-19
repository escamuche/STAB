package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.MetamagicFeat;
import com.stab.model.info.trait.Modifier;

public class FarShot_Feat extends MetamagicFeat{
	
	public static final String ID="FARSHOT_FEAT";

	
	
	public FarShot_Feat() {
			
		this.addRequiredTrait(PointBlankShot.ID);
	
	}
	
}