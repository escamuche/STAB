package com.stab.base.info.props;

import com.stab.model.info.base.Door;

public class RDoor  extends Door {

	public static final String ID="RDOOR";
	
	public void init() {
		super.init();
		setMaxHp(60);
		setMaxEp(0);
		healFully();
		setResource("rdoorClosed");
	}
	
	
	protected void open(){
	
		playSound("door_open");
		setResource("rdoorOpen");
		super.open();
	}
	
	protected void close(){
		playSound("door_close");
		setResource("rdoorClosed");
		super.close();
	}
	
}
