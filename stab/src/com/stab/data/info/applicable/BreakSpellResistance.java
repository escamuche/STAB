package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.OpposedSkillRoll;

public class BreakSpellResistance extends OpposedSkillRoll {

	
	//TODO: revisar, para cosas que tiren con un caster level fijo!
	
	public BreakSpellResistance(BaseInfo instigator, String skill,
			BaseInfo target) {
		super(instigator, skill, target, StabConstants.SPELLRESISTANCE);
		
	}

	
}
