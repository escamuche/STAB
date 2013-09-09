package com.stab.data.info.applicable;

import java.awt.Point;
import java.util.EnumSet;

import com.stab.common.fw.ServiceManager;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.HasDescriptor;
import com.stab.model.action.Action;
import com.stab.model.action.ActionLibrary;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.request.basic.ActionRequest;

public class ActionEffect extends Applicable implements HasDescriptor{

	
	Point point;
	
	Action action;
	ActionRequest ar;

	protected EnumSet<EffectDescriptor> descriptors;
	
	public ActionEffect(BaseInfo instigator,BaseInfo target,Point point, String action,ActionRequest ar) {
		super(instigator);
		setTarget(target);
		this.point=point;
		this.action=getActionLibrary().getAction(action);
		this.ar=ar;
	}

	protected static ActionLibrary getActionLibrary(){
		return ServiceManager.getService(ActionLibrary.class);
	}
	
	public Action getAction() {
		return action;
	}
	public ActionRequest getActionRequest() {
		return ar;
	}
	public Point getPoint() {
		return point;
	}
	
	@Override
	public void applyEffects() {
		getAction().affect((BaseInfo)getInstigator(), this.getTarget(),getPoint(), ar);
	}

	@Override
	public void validate() {
			
	}
	
	
	@Override
	public EnumSet<EffectDescriptor> getDescriptors() {
		return descriptors;
	}
	
	public void setDescriptors(EffectDescriptor arg0){
		descriptors= EnumSet.of(arg0);
	}
	
	public void setDescriptors(EffectDescriptor arg0,EffectDescriptor...arg1){
		descriptors= EnumSet.of(arg0, arg1);
	}
	
}
