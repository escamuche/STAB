package com.stab.data.info.props;

import com.stab.model.info.base.Door;

public class CDoor extends Door{

public static final String ID="CDOOR";

	public void init() {
		super.init();
		setMaxHp(60);
		setMaxEp(0);
		healFully();
		setResource("cdoorClosed");
	}
	
	
	protected void open(){
	
		playSound("door_open");
		setResource("cdoorOpen");
		super.open();
	}
	
	protected void close(){
		playSound("door_close");
		setResource("cdoorClosed");
		super.close();
	}
}
