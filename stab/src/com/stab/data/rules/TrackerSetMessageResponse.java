package com.stab.data.rules;

import com.stab.common.events.ManagedEvent;
import com.stab.common.events.Rule;


public class TrackerSetMessageResponse extends TrackerResponse {

	String message;

	
	public TrackerSetMessageResponse(int number,String message) {
		super(number);
		this.message=message;
	}
	
	@Override
	public boolean execute(Rule r, ManagedEvent e) {
		getTracker(e).setMessage(message);
		return true;
	}
	
}
