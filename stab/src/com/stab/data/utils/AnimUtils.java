package com.stab.data.utils;

import com.stab.client.VisualEngine;
import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.StabVisualEngine;
import com.stab.client.slick.base.updaters.SyncState;
import com.stab.common.fw.ServiceManager;
import com.tien.princess.engine.sprite.StateSprite;


public class AnimUtils {

	static StateSprite fake;
	static{
		fake=new StateSprite();
		fake.setVisible(false);
	}
	
	public static StateSprite getSprite(com.stab.model.basic.Sprite t){
		if(t.getVisualObject() instanceof SyncState){
			return ((SyncState)t.getVisualObject()).getSprite();
		}
		System.out.println("No encuentro el visualObject para "+t+"  "+t.getPos());
		return fake;
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
