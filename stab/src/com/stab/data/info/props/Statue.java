package com.stab.data.info.props;

import com.stab.model.info.base.Obstacle;

public class Statue extends Obstacle {

	public static final String ID="STATUE";

	
	public void init() {
		super.init();
		setMaxHp(60);
		setMaxEp(0);
		healFully();
		setResource("gargoylestatue");
		setText("");
		//Añadir traits de piedra
	}
}