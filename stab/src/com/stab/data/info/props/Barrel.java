package com.stab.data.info.props;

import com.stab.model.info.base.Obstacle;

public class Barrel extends Obstacle {

	public static final String ID="BARREL";

	
	public void init() {
		super.init();
		setMaxHp(5);
		setMaxEp(0);
		healFully();
		setResource("Barril");
		setDestroyedResource("BarrilRoto");
		setText("");
	}
	

	
}