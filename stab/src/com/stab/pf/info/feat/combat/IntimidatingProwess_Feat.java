package com.stab.pf.info.feat.combat;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;
import com.stab.pf.info.trait.PathfinderAttributeBonus;

public class IntimidatingProwess_Feat extends CombatFeat{
	
	public static final String ID="INTIMIDATINGPROWESS_FEAT";

	
	
	public IntimidatingProwess_Feat() {
			Modifier bonus = new PathfinderAttributeBonus(StabConstants.INTIMIDATE,StabConstants.STRENGHT);
			this.addTrait(bonus);
			}
	
}
