package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.PathfinderAttack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.BuffEffect;

public class SmiteEvil_Buff extends BuffEffect implements Attends<PathfinderAttack>{

	BaseInfo smitetarget = null;
	
    public void setSmiteTarget(BaseInfo smitetarget) {
		this.smitetarget = smitetarget;
	}
	
	@Override
	public void attend(PathfinderAttack arg0) {
		
		if(arg0.getInstigator() == smitetarget){
			BaseInfo paladin = arg0.getTarget();
			int bono = paladin.getAttributeValue(StabConstants.CHARISMA);
			arg0.addModifier(-bono);
		}
		
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		
	if(arg0 instanceof PathfinderAttack)				
		return true;
	return false;
	}





}
