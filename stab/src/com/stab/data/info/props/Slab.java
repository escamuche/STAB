package com.stab.data.info.props;

import com.stab.model.info.base.Decoration;

public class Slab extends Decoration {

	public static final String ID="SLAB";
	
	@Override
	public void init() {
		super.init();
		setResource("props/slab");
	}
	
}
