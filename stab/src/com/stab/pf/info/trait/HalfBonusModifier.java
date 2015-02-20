package com.stab.pf.info.trait;

import com.stab.model.info.trait.AttributeBasedModifier;

public class HalfBonusModifier extends AttributeBasedModifier {
	
	public HalfBonusModifier(String target, String from) {
		this(target,from,false);
	}
	
	public HalfBonusModifier(String target, String from,boolean useBaseValue) {
		super(target,from,useBaseValue);
	}
	
	
	@Override
	public int getValue() {
		return (int)((super.getValue()+1)/2);
	}

}
