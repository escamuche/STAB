package com.stab.cards.scene;

import com.stab.model.Scene;
import com.stab.model.basic.scenes.Lobby;
import com.stab.model.basic.ui.Backdrop;


public class DeckCreationScene extends Scene{

	public static final String ID =Lobby.ID;

	
	@Override
	public void init() {
		super.init();
		
		Backdrop bd=new Backdrop();
		
		add(bd);
		
	}

}
