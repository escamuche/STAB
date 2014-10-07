package com.stab.data.adventure.everflame;

import com.stab.data.info.props.CDoor;

public class CrackDoor extends CDoor{
	
	public static final String ID="CRACKDOOR";

	public void init() {
		super.init();
		setMaxHp(30);
		healFully();
		setResource("cdoorClosed"); //Pensarse si cambiarlo para hacerlo mas notable
		setText("Door");
		setDescription("A wooden door, with a small crack in the middle");
	}
	
}
