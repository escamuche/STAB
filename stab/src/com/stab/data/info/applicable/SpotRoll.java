package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;

public class SpotRoll extends SkillRoll {


	
	public SpotRoll(BaseInfo instigator,int dc) {
	 super(instigator,StabConstants.PERCEPTION, dc);
	}
}
