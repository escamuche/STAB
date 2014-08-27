package com.stab.data.info.props;

import com.stab.model.info.base.Obstacle;

public class Crate extends Obstacle {

	public static final String ID="CRATE";

	
	public void init() {
		super.init();
		setMaxHp(10);
		setMaxEp(0);
		healFully();
		setResource("crate");
		setText("Crate");
		setDescription("A wooden crate of unimportant contents");
		setDestroyedResource("brokenCrate");
		this.setBloodeffEct("PARTICLE#damage/splinterburst");
	}
}
