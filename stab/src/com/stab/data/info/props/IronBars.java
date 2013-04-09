package com.stab.data.info.props;

import com.stab.model.info.base.Door;

public class IronBars extends Door {

	public static final String ID="IRON_BARS";
	
	public void init() {
		super.init();
		setMaxHp(60);
		setMaxEp(0);
		healFully();
		close();
	}
	
	
	protected void open(){
	
		playSound("door_open");
		setResource("ironBarsOff");
		super.open();
	}
	
	protected void close(){
		playSound("door_close");
		setResource("ironBarsOn");
		super.close();
	}
	
}

