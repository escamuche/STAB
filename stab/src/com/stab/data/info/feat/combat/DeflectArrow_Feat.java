package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;

public class DeflectArrow_Feat extends CombatFeat{
	
	public static final String ID="DEFLECTARROW_FEAT";

	
	
	public DeflectArrow_Feat() {
		this.addRequiredAttribute(StabConstants.DEXTERITY, 13);
		this.addRequiredTrait(ImprovedUnarmedStrike_Feat.ID);
			}
	
}