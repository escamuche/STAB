package com.stab.data.info;

import com.stab.model.info.trait.AttributeBasedModifier;


public class PathfinderAttributeBonus extends AttributeBasedModifier {

	public PathfinderAttributeBonus(String target, String from) {
		super(target, from);
	}

	@Override
	protected int getBonusFrom(int val) {
			if (val>=10)
				return (val-10)/2;
			else
				return (val-11)/2;
	}

}
