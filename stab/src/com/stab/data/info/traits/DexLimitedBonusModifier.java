package com.stab.data.info.traits;

import com.stab.data.StabConstants;

public class DexLimitedBonusModifier extends PathfinderAttributeBonus{

	
	
	
	public DexLimitedBonusModifier(String target) {
		super(target, StabConstants.DEXTERITY);
	}

	@Override
	public int getValue() {
		int i= super.getValue();
		int limit=getTarget().getValue(StabConstants.DEXLIMIT);
		if (limit<i)
			return limit;
		return i;
	}
}
