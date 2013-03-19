package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class RangedAttack  extends Attack {

	public RangedAttack(BaseInfo instigator) {
		super(instigator);
	}
	
	
	@Override
	public void setInstigator(Info instigator) {
		super.setInstigator(instigator);
		setModifier(((BaseInfo)instigator).getValue(StabConstants.TOHITRANGED));
	}

}
