package com.stab.pf.actions.general;

import com.stab.model.action.Action;
import com.stab.model.action.DelegatedAction;
import com.stab.model.action.base.PassAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class PassDefendAction extends DelegatedAction {

	public static final String ID="PASSDEFEND";
	
	public PassDefendAction() {
		setTargetMode(SELF);
		setUsableByAI(false);
		setEffectType(POSITIVE);
		setRelations(Action.TARGET_SELF);
		setDefaultAIValue(0);
		setAPCost(0);
		setInnerAction(PassAction.ID);
	}
	
	@Override
	public int getAPCost() {
		return 0;
	}
	

	public boolean validateActor(Info i, ActionRequest ar) {
		
		if (i instanceof BaseInfo){
			BaseInfo info=((BaseInfo)i);
			if (info.getActionPoints()>0)
				setInnerAction(DefendAction.ID);
			else
				setInnerAction(PassAction.ID);
		}
		return super.validateActor(i, ar);
	};

}
