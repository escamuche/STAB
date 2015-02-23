package com.stab.data.info.other;

import com.stab.model.info.trait.base.InteractToAction;
import com.stab.pf.actions.general.PushAction;

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
