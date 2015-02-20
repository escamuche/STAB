package com.stab.pf.info.feat.combat;

import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class DeflectArrow_Feat extends CombatFeat{
	
	public static final String ID="DEFLECTARROW_FEAT";

	
	
	public DeflectArrow_Feat() {
		this.addRequiredAttribute(StabConstants.DEXTERITY, 13);
		this.addRequiredTrait(ImprovedUnarmedStrike_Feat.ID);
			}
	
}