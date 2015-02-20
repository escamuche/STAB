package com.stab.pf.info.monster.monstertraits;

import com.stab.model.info.trait.AttributeBasedModifier;
import com.stab.pf.StabConstants;

public class ConstructSizeExtraHpModifier extends AttributeBasedModifier {

	int factor;
	static int[]values=new int[]{0,0,0,10,20,30,40,60,80};
	
	public ConstructSizeExtraHpModifier() {
		super(StabConstants.MAXHP, StabConstants.SIZE);
		setCategory(StabConstants.SIZEMOD);
	}

	@Override
	protected int getBonusFrom(int val) {
		int i=values[val];
		return i;
	}

}
