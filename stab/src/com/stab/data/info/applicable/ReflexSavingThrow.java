package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.Info;

public class ReflexSavingThrow extends SavingThrowEffect{

	public ReflexSavingThrow(int diff) {
		this(null,diff);
	}
	public ReflexSavingThrow(Info instigator,  int diff) {
		super(instigator, StabConstants.REFLEXSAVE, diff);
	}

	@Override
	public void apply() {
		
	}

}
