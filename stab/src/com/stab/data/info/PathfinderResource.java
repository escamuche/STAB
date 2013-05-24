package com.stab.data.info;

import com.stab.data.utils.PathfinderUtils;
import com.stab.model.info.trait.base.RenewableResource;

public class PathfinderResource extends RenewableResource {

	String attr="";
	
	public PathfinderResource(String type, int amount, String attribute) {
		super(type, amount);
		this.attr=attribute;
	}
	
	
	@Override
	public int getMax() {
		int m=super.getMax();
		int bonus=0;
		bonus= PathfinderUtils.getBonus(this.getTarget().getAttributeValue(attr));
		if (bonus<0)
			bonus=0;
		m=m+bonus;
		return m;
	}

}
