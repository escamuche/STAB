package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.MetamagicFeat;
import com.stab.model.info.trait.Modifier;

public class PointBlankShot extends MetamagicFeat{
	
	public static final String ID="POINTBLANKSHOT_FEAT";

	
	
	public PointBlankShot() {
			
		Modifier hit = Modifier.createMod(StabConstants.TOHITRANGED,1);
		this.addTrait(hit);
		Modifier damage = Modifier.createMod(StabConstants.DAMAGERANGED,1);
		this.addTrait(damage);
	
	}
	
}