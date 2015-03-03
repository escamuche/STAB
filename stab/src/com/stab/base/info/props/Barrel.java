package com.stab.base.info.props;

import com.stab.base.info.other.Pushable;

public class Barrel extends Cover {

	public static final String ID="BARREL";

	
	public void init() {
		super.init();
		setMaxHp(5);
		setMaxEp(0);
		healFully();
		setResource("props/barrel");
		setDestroyedResource("brokenWood");
		setText("Barrel");
		setDescription("A heavy wooden barrel, with unknown contents.");
		addTrait(new Pushable(8));
		this.setBloodeffEct("PARTICLE#damage/splinterburst");
	}
	

	
}