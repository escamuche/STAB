package com.stab.data.actions.companion;

import java.awt.Point;

import com.stab.model.action.ContextualAction;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class DismissCompanionAction extends ContextualAction {
	
	public static final String ID="DISMISS_COMPANION_ACTION";
	
	
	public DismissCompanionAction() {
		setRange(15);
		setName("Dismiss companion");
		setResource("actions/spells/dismiss");
		setDescription("Dismiss your companion, telling him to go away");
		setLosType(IN_SIGHT);
		
	}


	@Override
	public int affect(Info instigator, Info target, Point point,
			ActionRequest ar) {


		return OK;
	}
}
