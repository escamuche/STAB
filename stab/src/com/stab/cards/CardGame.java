package com.stab.cards;

import com.stab.adventure.Game;

public class CardGame extends Game {

	
	@Override
	public void init() {
		super.init();
		setGamelogic(new CardGameLogic());
	}
	

}
