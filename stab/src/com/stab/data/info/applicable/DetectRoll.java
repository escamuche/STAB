package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.OpposedSkillRoll;

public class DetectRoll extends OpposedSkillRoll {

	public DetectRoll(BaseInfo instigator,  BaseInfo target) {
		super(instigator, StabConstants.PERCEPTION, target, StabConstants.PERCEPTION_DC);
	}

	
}
