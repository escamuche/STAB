package com.stab.data.info.traits;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.AttributeBasedModifier;

public class SizeModifier extends AttributeBasedModifier {

	int factor;
	static int[]values=new int[]{8,4,2,1,0,-1,-2,-4,-8};
	
	public SizeModifier(String target,int factor) {
		super(target, StabConstants.SIZE);
		this.factor=factor;
		setCategory(StabConstants.SIZEMOD);
	}

	@Override
	protected int getBonusFrom(int val) {
			int i=values[val];
			i=i*factor;
			return i;
	}


}
