package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.OpposedSkillRoll;

public class BreakSpellResistance extends OpposedSkillRoll {

	public BreakSpellResistance(BaseInfo instigator, String skill,
			BaseInfo target) {
		super(instigator, skill, target, StabConstants.SPELLRESISTANCE);
		
	}

	
}
