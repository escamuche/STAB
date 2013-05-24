package com.stab.data.info.applicable;

import java.awt.Point;

import com.stab.common.fw.ServiceManager;
import com.stab.model.action.Action;
import com.stab.model.action.ActionLibrary;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;

public class ActionEffect extends Applicable{

	
	Point point;
	
	Action action;

	
	
	public ActionEffect(BaseInfo instigator,BaseInfo target,Point point, String action) {
		super(instigator);
		setTarget(target);
		this.point=point;
		this.action=getActionLibrary().getAction(action);
	}

	protected static ActionLibrary getActionLibrary(){
		return ServiceManager.getService(ActionLibrary.class);
	}
	
	public Action getAction() {
		return action;
	}
	
	public Point getPoint() {
		return point;
	}
	
	@Override
	public void applyEffects() {
		getAction().affect((BaseInfo)getInstigator(), this.getTarget(),getPoint());
	}

	@Override
	public void validate() {
			
	}
	
	
}
