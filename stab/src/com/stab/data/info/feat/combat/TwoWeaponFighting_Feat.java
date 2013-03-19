package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class TwoWeaponFighting_Feat extends CombatFeat{
	
	public static final String ID="TWOWEAPONFIGHTING_FEAT";

	
	
	public TwoWeaponFighting_Feat() {
		
		this.addRequiredAttribute(StabConstants.DEXTERITY, 15);
			
	}
	
}