package com.stab.pf.info.applicable;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.OpposedSkillRoll;
import com.stab.pf.StabConstants;

public class DetectRoll extends OpposedSkillRoll {

	public DetectRoll(BaseInfo instigator,  BaseInfo target) {
		super(instigator, StabConstants.PERCEPTION, target, StabConstants.PERCEPTION_DC);
	}

	
}
