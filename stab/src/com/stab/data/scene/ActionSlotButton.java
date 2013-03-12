package com.stab.data.scene;

import com.stab.common.Constants;
import com.stab.model.action.Action;
import com.stab.model.basic.ui.Button;

public class ActionSlotButton extends Button {

	public static final String ID="ACTIONSLOTBUTTON_ENTITY";
	
	int slot;
	Action action;
	
	@Override
	public void init() {
		super.init();
		action=null;
		slot=-1;
		this.setSize(80, 80);
		this.setMode(Constants.ICON);
	}
	
	public void setSlot(int slot) {
		this.slot = slot;
		this.setAction("ACTION"+slot);
	}
	
	public int getSlot() {
		return slot;
	}
	
		
	public void setAssociatedAction(Action action) {
		this.action = action;
		this.setIcon(action.getResource());
		this.setText(action.getName());
	}
	
	public Action getAssociatedAction(){
		return action;
	}
	
	
}
