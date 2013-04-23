package com.stab.data;

import com.stab.adventure.Game;

public class PathfinderGame extends Game {

	
	@Override
	public void init() {
		super.init();
		setGamelogic(new PathfinderGameLogic());
	}
	
}
