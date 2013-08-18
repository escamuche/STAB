package com.stab.data.utils;

import com.stab.client.VisualEngine;
import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.StabVisualEngine;
import com.stab.client.slick.base.updaters.SyncState;
import com.stab.common.fw.ServiceManager;
import com.tien.princess.engine.sprite.StateSprite;


public class AnimUtils {

	public static StateSprite getSprite(com.stab.model.basic.Sprite t){
		if(t.getVisualObject() instanceof SyncState){
			return ((SyncState)t.getVisualObject()).getSprite();
		}
		return null;
	}
	
	public static void spawnSprite(){
		
	}
	
	
	public static void playSound(){
		
	}
	
	public static AbstractGameScreen getScreen(){
		VisualEngine ve=ServiceManager.getService(VisualEngine.class);
		return ((StabVisualEngine)ve).getGameScreen();
	}

	public static AbstractGameScreen getScreen(com.stab.model.basic.Sprite source) {
		return (AbstractGameScreen)getSprite(source).getScreen();
	}
}
