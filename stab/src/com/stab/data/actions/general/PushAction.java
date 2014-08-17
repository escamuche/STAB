package com.stab.data.actions.general;

import java.awt.Point;

import com.stab.model.action.Action;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class PushAction extends Action {

	@Override
	public int affect(Info instigator, Info target, Point point,
			ActionRequest ar) {
	
		return OK;
	}

}
