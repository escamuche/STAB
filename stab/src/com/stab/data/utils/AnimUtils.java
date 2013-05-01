package com.stab.data.utils;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.updaters.SyncState;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.model.basic.Sprite;

public class AnimUtils {

	public static Token_sprite getSprite(Sprite t){
		if(t.getVisualObject() instanceof SyncState){
			return (Token_sprite)((SyncState)t.getVisualObject()).getSprite();
		}
		return null;
	}
	
	public static void spawnSprite(){
		
	}
	
	
	public static void playSound(){
		
	}

	public static AbstractGameScreen getScreen(Sprite source) {
		return (AbstractGameScreen)getSprite(source).getScreen();
	}
}
