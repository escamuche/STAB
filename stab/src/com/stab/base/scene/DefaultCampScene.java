package com.stab.base.scene;

import com.stab.model.basic.scenes.MapLogic;
import com.stab.model.basic.scenes.NarrationMapLogic;
import com.stab.model.basic.scenes.TokenBasedScene;
import com.stab.model.request.TurnQueue;

public class DefaultCampScene extends TokenBasedScene {

	
	
	@Override
	public void init() {
		super.init();
		this.setBackground("art/camp$C");
		this.setUnlocked(true);
	}
	
	
	@Override
	protected TurnQueue createTurnQueue() {
		return super.createTurnQueue();
	}
	protected  MapLogic createMapLogic(){
		return new NarrationMapLogic(this);
	}
	
}
