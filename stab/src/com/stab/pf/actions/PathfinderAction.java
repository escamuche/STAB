package com.stab.pf.actions;

import com.stab.model.action.Action;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;

public abstract class PathfinderAction extends Action {

	public static final String FREE_ACTION=StabConstants.FREE_ACTION;
	public static final String SWIFT_ACTION=StabConstants.SWIFT_ACTION;
	public static final String MOVE_ACTION=StabConstants.MOVE_ACTION;
	public static final String STANDARD_ACTION=StabConstants.STANDARD_ACTION;
	public static final String FULLROUND_ACTION=StabConstants.FULLROUND_ACTION;
	
	
	String actionType=STANDARD_ACTION;
	
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getActionType(Info i){ //Aqui iran modificaciones posibles, ej:rapidreaload
		return actionType;
	}
	
	
	
	@Override
	public boolean payCost(ActionRequest ar) {
		boolean b=super.payCost(ar);
		if (!b)
			return false;
		
		
		return true;
	}
	
	
}
