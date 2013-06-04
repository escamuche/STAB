package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.PathfinderAttributeBonus;
import com.stab.data.info.feat.CombatFeat;

public class AgileManeuvers_Feats extends CombatFeat{
	
	public static final String ID="AGILEMANEUVERS_FEAT";

	
	
	public AgileManeuvers_Feats() {
		
	//	i.removeTrait("PathfinderAttributeBonus(StabConstants.CMB,StabConstants.STRENGHT)");
		this.addTrait(new PathfinderAttributeBonus(StabConstants.CMB,StabConstants.DEXTERITY));
			}
	
}