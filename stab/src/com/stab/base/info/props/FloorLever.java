package com.stab.base.info.props;

import com.stab.model.info.base.Lever;
import com.stab.model.info.interfaces.RemoteActivated;

public class FloorLever extends Lever implements RemoteActivated{

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
	
	public void channelOn() {
		setState(ON);
	}
	public void channelOff() {
		setState(OFF);
	}
	
	
}
