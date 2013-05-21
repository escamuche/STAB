package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.PathfinderAttributeBonus;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.BaseInfo;

public class AgileManeuvers_Feats extends CombatFeat{
	
	public static final String ID="AGILEMANEUVERS_FEAT";

	
	
	public AgileManeuvers_Feats() {
		
		BaseInfo i = (BaseInfo) getTarget();
	//	i.removeTrait("PathfinderAttributeBonus(StabConstants.CMB,StabConstants.STRENGHT)");
		i.addTrait(new PathfinderAttributeBonus(StabConstants.CMB,StabConstants.DEXTERITY));
			}
	
}