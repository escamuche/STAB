package com.stab.data.animation.state;

import com.tien.princess.engine.sprite.common.states.State;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;

public class SpeechPanelState extends State{
	
	
	public static final String ID="SPEECHSTATE";
	
	@Override
	public String getId() {
		return ID;
	}
	
	
	public SpeechPanelState() {
		//this.setTimed(t, "FADE");
		addUpdater(new Orbit());
	//	addUpdater(new CapBounds());
	}

}
