package com.stab.data.info.debuff.condition;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Debuff;

public class BlindCondition extends Debuff  {

	public static final String ID="BLINDEDCONDITION_DEBUFF";
	
	public BlindCondition() {
		
		this.setName("Blinded");
		
		Modifier ac = new Modifier(StabConstants.PASSIVEDEFENSE,-2);
		
		addTrait(ac);
		
		
	}
}
