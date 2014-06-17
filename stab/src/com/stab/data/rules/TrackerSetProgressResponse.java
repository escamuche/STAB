package com.stab.data.rules;

import com.stab.common.events.ManagedEvent;
import com.stab.common.events.Rule;

public class TrackerSetProgressResponse extends TrackerResponse {

	int value;

	public TrackerSetProgressResponse(int number,int value) {
		super(number);
		this.value=value;
	}
	
	@Override
	public boolean execute(Rule r, ManagedEvent e) {
		getTracker(e).setProgress(value);
		return true;
	}
	
}
