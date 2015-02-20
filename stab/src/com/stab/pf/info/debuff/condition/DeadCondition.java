package com.stab.pf.info.debuff.condition;

import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Heal;

public class DeadCondition extends UnableToActCondition implements Attends<Heal>{
	
	
	public static final String ID="DEADCONDITION_DEBUFF";
	
	public DeadCondition()  {
	
		this.setAnimIcon("actions/deadcondition");				
		this.setSound("HolyCast");
		this.setResource("actions/deadcondition");                  
		
		this.setName("Dead");
		this.setPermanent();
		addTrait(new CannotThreatCondition());
		
		
	}

	@Override
	public void attend(Heal arg0) {
		arg0.setResult(Applicable.INMUNE);
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		if(arg0 instanceof Heal)
			return true;
		return false;
	}
}
