package com.stab.pf.info.feat.combat;

import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;
import com.stab.pf.info.trait.PathfinderAttributeBonus;

public class AgileManeuvers_Feats extends CombatFeat{
	
	public static final String ID="AGILEMANEUVERS_FEAT";

	
	
	public AgileManeuvers_Feats() {
		
	//	i.removeTrait("PathfinderAttributeBonus(StabConstants.CMB,StabConstants.STRENGHT)");
		this.addTrait(new PathfinderAttributeBonus(StabConstants.CMB,StabConstants.DEXTERITY));
			}
	
}