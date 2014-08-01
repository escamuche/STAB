package com.stab.data.info.props;

import com.stab.model.info.base.Lever;

public class FloorLever extends Lever {

	public static final String ID="FLOOR_LEVER";
	
	
	@Override
	public void setState(int state) {
		super.setState(state);
		playSound("door_close");
		if (state==ON){
			setResource("props/leverl_on");
		}
		if (state==OFF){
			setResource("props/lever_off");
		}
	}
	
	
	
}
