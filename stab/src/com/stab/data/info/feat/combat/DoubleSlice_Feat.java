package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class DoubleSlice_Feat extends CombatFeat{
	
	public static final String ID="DOUBLESLICE_FEAT";

	
	
	public DoubleSlice_Feat() {
		
		this.addRequiredTrait(TwoWeaponFighting_Feat.ID);
		
			}
	
}