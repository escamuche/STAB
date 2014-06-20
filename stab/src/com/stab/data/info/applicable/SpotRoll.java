package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.SkillRoll;

public class SpotRoll extends SkillRoll {


	
	public SpotRoll(BaseInfo instigator,int dc) {
	 super(instigator,StabConstants.PERCEPTION, dc);
	}
}
