package com.stab.base.info.props;

import com.stab.base.animation.CloseDoorAnimation;
import com.stab.base.animation.OpenDoorAnimation;
import com.stab.model.info.base.Door;

public class WoodenDoor extends Door {

	public static final String ID="WOODEN_DOOR";
	
	public void init() {
		super.init();
		setMaxHp(60);
		setMaxEp(0);
		healFully();
		setResource("door&0");
	}
	
	
	protected void open(){
		playAnimation(OpenDoorAnimation.ID);
		playSound("door_open");
		
		super.open();
	}
	
	protected void close(){
		playAnimation(CloseDoorAnimation.ID);
		playSound("door_close");
		super.close();
	}
	
}
