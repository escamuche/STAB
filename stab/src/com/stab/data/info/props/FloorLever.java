package com.stab.data.info.props;

import com.stab.model.info.base.Lever;

public class FloorLever extends Lever {

	public static final String ID="FLOOR_LEVER";
	
	
	@Override
	public void init() {
		super.init();
		setText("Lever");
		setState(OFF);
	}
	
	@Override
	public void setState(int state) {
		super.setState(state);
		playSound("door_close");
		if (state==ON){
			setResource("props/lever_on");
		}
		if (state==OFF){
			setResource("props/lever_off");
		}
	}
	
	
	
}
