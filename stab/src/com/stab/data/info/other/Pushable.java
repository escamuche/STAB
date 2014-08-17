package com.stab.data.info.other;

import com.stab.data.actions.general.PushAction;
import com.stab.model.info.trait.base.InteractToAction;

public class Pushable extends InteractToAction {

	
	int dc;
	
	public Pushable(int dc) {
		super(PushAction.ID);
		this.dc=dc;
	}
	
	public int getDc() {
		return dc;
	}
	
}
