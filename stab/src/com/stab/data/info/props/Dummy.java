package com.stab.data.info.props;

import com.stab.data.StabConstants;
import com.stab.model.info.base.Obstacle;

public class Dummy extends Obstacle {

   public static final String ID="DUMMY";

	
	public void init() {
		super.init();
		setMaxHp(70);
		setMaxEp(0);
		healFully();
		setResource("dummy");
		setText("");
		this.setAttribute(StabConstants.ARMOR,12);
		
	}
	
	@Override
	public void die() {
		super.die();
		setResource("BarrilRoto");
	}
	
}