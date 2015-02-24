package com.stab.adventure.everflame;

import com.stab.common.Constants;
import com.stab.model.action.ActionLibrary;
import com.stab.model.basic.token.Token;
import com.stab.model.extras.ContextualOption;
import com.stab.model.info.base.Decoration;

public class ClimbWaypoint extends Decoration {

	
	public static final String ID="CLIMB_WAYPOINT";
	
	@Override
	public void init() {
		super.init();
		setResource("waypoint");
		setSelectable(Token.SELECTABLE);
		setDepth(Constants.AURAS);
		//Añadir contextualAction
		ContextualOption op= new ContextualOption();
		op.setAction(ActionLibrary.getActionLibrary().getAction(ClimbAction.ID));
		addExtra(op);
	}
	
	

	
}
