package com.stab.pf.info.feat.combat;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class PointBlankShot_Feat extends CombatFeat{
	
	public static final String ID="POINTBLANKSHOT_FEAT";

	
	
	public PointBlankShot_Feat() {
			
		Modifier hit = new Modifier(StabConstants.TOHITRANGED,1);
		this.addTrait(hit);
		Modifier damage = new Modifier(StabConstants.DAMAGERANGED,1);
		this.addTrait(damage);
	
	}
	
}