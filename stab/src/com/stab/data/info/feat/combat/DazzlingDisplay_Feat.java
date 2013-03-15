package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class DazzlingDisplay_Feat extends CombatFeat{
	
	public static final String ID="DAZZLINGDISPLAY_FEAT";

	
	
	public DazzlingDisplay_Feat() {
		this.addRequiredTrait(WeaponFocus_Feat.ID);
			}
	
}
