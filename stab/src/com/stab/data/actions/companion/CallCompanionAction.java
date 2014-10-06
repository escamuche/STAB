package com.stab.data.actions.companion;

import java.awt.Point;

import com.stab.data.info.traits.HasCompanion;
import com.stab.model.action.ContextualAction;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;
import com.stab.model.request.basic.ActionRequest;

public class CallCompanionAction extends ContextualAction {
	
	public static final String ID="DISMISS_COMPANION_ACTION";
	
	HasCompanion trait;
	
	public CallCompanionAction(HasCompanion hc) {
		setRange(1);
		trait=hc;
		setName("Call companion");
		setResource("actions/spells/dismiss");
		setDescription("Calls for your companion to join you");
		setLosType(IN_SIGHT);
		
		Creature companion=trait.getCompanion();
		if (companion==null){
			
		}else{
		   setName ("Call "+companion.getText());
		   setResource("tokens"+companion.getResource());
		}
		
	}

	@Override
	public int affect(Info instigator, Info target, Point point,
			ActionRequest ar) {
		
		return OK;
	}
}
