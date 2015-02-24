package com.stab.adventure.everflame;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Attack;
import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.StabConstants;
import com.stab.pf.info.applicable.PathfinderAttack;
import com.stab.pf.info.applicable.SavingThrowEffect;

public class Illusion_Buff extends BuffEffect implements Affects<PathfinderAttack>, Attends<PathfinderAttack> {

	@Override
	public void affect(PathfinderAttack arg0) {
		
		BaseInfo target=getTarget();
		BaseInfo instigator = (BaseInfo) arg0.getInstigator();
		SavingThrowEffect d = new SavingThrowEffect(instigator,StabConstants.WILLSAVE,target);
		d.setTargetNumber(16);
		d.check();
		if(d.success()){
			arg0.setResult(Attack.FAIL);
			instigator.die();
		}
		else{
			
		}
			
		
	}

	@Override
	public boolean canAffect(Applicable arg0) {
		if(arg0 instanceof PathfinderAttack)
			return true;
		else
			return false;
	}

	@Override
	public void attend(PathfinderAttack arg0) {
		
		BaseInfo target = arg0.getTarget();
		BaseInfo instigator = (BaseInfo) arg0.getInstigator();
		SavingThrowEffect d = new SavingThrowEffect(target, StabConstants.WILLSAVE, instigator);
		d.setTargetNumber(16);
		d.check();
		if(d.success()){
			target.die();
		}
		
		else {
			
		}
		
		
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		if(arg0 instanceof PathfinderAttack)
			return true;
		else
			return false;
	}

}
