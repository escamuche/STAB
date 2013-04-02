package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.Info;

public class WillSavingThrow extends SavingThrowEffect{

	public WillSavingThrow(int diff) {
		this(null,diff);
	}
	public WillSavingThrow(Info instigator,  int diff) {
		super(instigator, StabConstants.WILLSAVE, diff);
	}

	@Override
	public void apply() {
		
	}

}
