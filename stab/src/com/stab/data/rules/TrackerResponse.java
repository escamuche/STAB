package com.stab.data.rules;

import com.stab.common.events.ManagedEvent;
import com.stab.common.events.Response;
import com.stab.data.scene.DefaultStabMapScene;
import com.stab.data.scene.QuestTracker;
import com.stab.model.basic.scenes.event.SceneEvent;

public abstract class TrackerResponse extends Response {
	
	int tracker;
	
	public TrackerResponse(int tracker) {
		super();
		this.tracker=tracker;
	}
	
	public int getTracker() {
		return tracker;
	}

	
	
	public QuestTracker getTracker(ManagedEvent e){
		if (e instanceof SceneEvent){
			return ((DefaultStabMapScene)((SceneEvent)e).getScene()).getTracker(getTracker());
		}
		return null;
	}
}
