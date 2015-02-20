package com.stab.pf.info.applicable;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.pf.StabConstants;

public class SpotRoll extends SkillRoll {


	
	public SpotRoll(BaseInfo instigator,int dc) {
	 super(instigator,StabConstants.PERCEPTION, dc);
	}
}
