package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.Attack;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.Buff;

public class Illusion_Buff extends Buff implements Affects<Attack>, Attends<Attack> {

	@Override
	public void affect(Attack arg0) {
		
		BaseInfo target=getTarget();
		BaseInfo instigator = (BaseInfo) arg0.getInstigator();
		SavingThrowEffect d = new SavingThrowEffect(instigator,StabConstants.WILLSAVE,target);
		d.setTargetNumber(16);
		d.check();
		if(d.success()){
			arg0.setResult(Attack.FAIL);
			instigator.destroy();
		}
		else{
			
		}
			
		
	}

	@Override
	public boolean canAffect(Applicable arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void attend(Attack arg0) {
		
		BaseInfo target = arg0.getTarget();
		BaseInfo instigator = (BaseInfo) arg0.getInstigator();
		SavingThrowEffect d = new SavingThrowEffect(target, StabConstants.WILLSAVE, instigator);
		d.setTargetNumber(16);
		d.check();
		if(d.success()){
			instigator.destroy();
		}
		
		else {
			
		}
		
		
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
