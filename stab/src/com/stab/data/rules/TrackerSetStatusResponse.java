package com.stab.data.rules;

import com.stab.common.events.ManagedEvent;
import com.stab.common.events.Rule;

public class TrackerSetStatusResponse extends TrackerResponse {

	int state;

	public TrackerSetStatusResponse(int number,int state) {
		super(number);
		this.state=state;
	}
	
	@Override
	public boolean execute(Rule r, ManagedEvent e) {
		getTracker(e).setState(state);
		return true;
	}
	
}
