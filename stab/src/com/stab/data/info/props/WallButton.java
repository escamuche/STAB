package com.stab.data.info.props;

import com.stab.model.info.base.PushButton;

public class WallButton extends PushButton {

	public static String ID="WALLBUTTON";
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		setState(OFF);
		setText("Button");
		setDescription("A small section on the wall that can be pushed. You'll need to be very close to it to activate it.");
	}
	
	
	@Override
	public int getDistance() {
		return 0;
	}
	
	@Override
	public void setState(int state) {
		super.setState(state);
		if (state==ON){
			setResource("wallButtonPressed");
			playSound("door_close");
		}
		if (state==OFF){
			setResource("wallButton");
	
		}
	}
	
	
			
}
