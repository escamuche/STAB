package com.stab.data.actions.monster;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.RangedKill;
import com.stab.model.info.BaseInfo;
import com.stab.util.Roll;

public class SkeletonRangedAction extends RangedKill {
	
	public static final String ID="SKELETONRANGED_ATTACK";
	
	protected String getSwingImage(BaseInfo atacante) {
		return "effects/arrow";
	}
	
	@Override
	protected int getBaseDamage(BaseInfo Atacante) {
		return Roll.d6()+Atacante.getAttributeValue(StabConstants.DAMAGE);
	}

}
