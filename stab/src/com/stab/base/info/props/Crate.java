package com.stab.base.info.props;


public class Crate extends Cover {

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
