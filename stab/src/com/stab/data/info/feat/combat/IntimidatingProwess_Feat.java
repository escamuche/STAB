package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.PathfinderAttributeBonus;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.BaseInfo;

public class IntimidatingProwess_Feat extends CombatFeat{
	
	public static final String ID="INTIMIDATINGPROWESS_FEAT";

	
	
	public IntimidatingProwess_Feat() {
			BaseInfo i = (BaseInfo) getTarget();
			i.addTrait(new PathfinderAttributeBonus(StabConstants.INTIMIDATE,StabConstants.STRENGHT));
			}
	
}
