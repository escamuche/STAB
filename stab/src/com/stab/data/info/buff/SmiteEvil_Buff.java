package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.Attack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.Buff;

public class SmiteEvil_Buff extends Buff implements Attends<Attack>{

	BaseInfo smitetarget = null;
	
    public void setSmiteTarget(BaseInfo smitetarget) {
		this.smitetarget = smitetarget;
	}
	
	@Override
	public void attend(Attack arg0) {
		
		if(arg0.getInstigator() == smitetarget){
			BaseInfo paladin = arg0.getTarget();
			int bono = paladin.getAttributeValue(StabConstants.CHARISMA);
			arg0.addModifier(-bono);
		}
		
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		
	if(arg0 instanceof Attack)				
		return true;
	return false;
	}





}
