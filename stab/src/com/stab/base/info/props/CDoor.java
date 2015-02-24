package com.stab.base.info.props;

import com.stab.model.info.base.Door;

public class CDoor extends Door{

public static final String ID="CDOOR";

	public void init() {
		super.init();
		setMaxHp(60);
		setMaxEp(0);
		healFully();
		setResource("cdoorClosed");
		setText("Door");
		setDescription("A wooden door");
		this.setBloodeffEct("PARTICLE#damage/splinterburst");
	}
	
	
	protected void open(){
	
		playSound("door_open");
		setResource("cdoorOpen");
		super.open();
	}
	
	protected void close(){
		playSound("door_close");
		setResource("cdoorClosed$A");
		super.close();
	}
	
	@Override
		public void setState(int state) {
			if (state==DESTROYED_STATE)
				setResource("cdoorOpen$A");
			super.setState(state);
		}
	
	
}
