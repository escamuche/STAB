package com.stab.cards;

import com.stab.cards.scene.DeckCreationScene;
import com.stab.common.fw.Loader;
import com.stab.fw.ModInfo;
import com.stab.fw.Module;

@ModInfo(
		id = "CARDS_MODULE", 
		name = "Fantasy Deck base Module",
		description="A module with the base for fantasy Deck games",
		version= 1.0,
		priority=10,
		clientNeeded=true
		) 
public class CardsModule extends Module {

	public static final String ID="CARDS_MODULE";
	
	public void commonInit(){
		
	//	Loader.addDir("fantasy");
		
	}
	
	
	@Override
	public void serverInit() {
		super.serverInit();
	
	}
	
	 void initFactory(){
			
		 setMapping(DeckCreationScene.class);
	 }
	 
}
