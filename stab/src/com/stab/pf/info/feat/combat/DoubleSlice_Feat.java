package com.stab.pf.info.feat.combat;

import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class DoubleSlice_Feat extends CombatFeat{
	
	public static final String ID="DOUBLESLICE_FEAT";

	
	
	public DoubleSlice_Feat() {
		
		this.addRequiredAttribute(StabConstants.DEXTERITY, 15);
		this.addRequiredTrait(TwoWeaponFighting_Feat.ID);
		
			}
	
}