package com.stab.pf.info.feat.combat;

import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class TwoWeaponFighting_Feat extends CombatFeat{
	
	public static final String ID="TWOWEAPONFIGHTING_FEAT";

	
	
	public TwoWeaponFighting_Feat() {
		
		this.addRequiredAttribute(StabConstants.DEXTERITY, 15);
			
	}
	
}