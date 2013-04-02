package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.Info;

public class FortitudeSavingThrow extends SavingThrowEffect{

	public FortitudeSavingThrow(int diff) {
		this(null,diff);
	}
	public FortitudeSavingThrow(Info instigator,  int diff) {
		super(instigator, StabConstants.FORTITUDESAVE, diff);
	}

	@Override
	public void apply() {
		
	}

}
