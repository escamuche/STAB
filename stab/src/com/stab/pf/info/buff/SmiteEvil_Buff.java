package com.stab.pf.info.buff;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.StabConstants;
import com.stab.pf.info.applicable.PathfinderAttack;

public class SmiteEvil_Buff extends BuffEffect implements Attends<PathfinderAttack>, Affects<Damage>{

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

	@Override
	public boolean canAffect(Applicable a) {
		if (a instanceof Damage)
			return true;
		return false;
	}

	@Override
	public void affect(Damage app) {
		if (app.getTarget()==smitetarget)
			app.setIgnoreAllResistance(true);
	}





}
