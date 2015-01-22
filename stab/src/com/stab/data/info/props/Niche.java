package com.stab.data.info.props;

import com.stab.model.info.base.Decoration;

public class Niche extends Decoration {

	public static final String ID="NICHE";
	
	@Override
	public void init() {
		super.init();
		setResource("props/niche");
	}
}
