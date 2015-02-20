package com.stab.pf.info.applicable;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.OpposedSkillRoll;
import com.stab.pf.StabConstants;

public class BreakSpellResistance extends OpposedSkillRoll {

	
	//TODO: revisar, para cosas que tiren con un caster level fijo!
	
	public BreakSpellResistance(BaseInfo instigator, String skill,
			BaseInfo target) {
		super(instigator, skill, target, StabConstants.SPELLRESISTANCE);
		
	}

	
}
