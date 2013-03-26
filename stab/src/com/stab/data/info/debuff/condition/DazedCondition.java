package com.stab.data.info.debuff.condition;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Debuff;

public class DazedCondition extends Debuff{

	public static final String ID="DAZEDCONDITION_DEBUFF";
	
	BaseInfo i = getTarget();
	
	public DazedCondition() {
		
		
		
	}
	
	@Override
	public void turnStarts() {
		i.setTurnDone(true);
		super.turnStarts();
	}
	
	
	
	
}
