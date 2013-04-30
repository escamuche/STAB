package com.stab.data.info.props;

import com.stab.model.info.base.Door;

public class LDoor extends Door {

	public static final String ID="LDOOR";
	
	public void init() {
		super.init();
		setMaxHp(60);
		setMaxEp(0);
		healFully();
		setResource("ldoorClosed");
	}
	
	
	protected void open(){
	
		playSound("door_open");
		setResource("ldoorOpen");
		super.open();
	}
	
	protected void close(){
		playSound("door_close");
		setResource("ldoorClosed");
		super.close();
	}
	
}