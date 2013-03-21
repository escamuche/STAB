package com.stab.data.info.debuff;

import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Buff;

public class Rage_Debuff extends Buff {

	public static final String ID="RAGE_DEBUFF";
	
	public Rage_Debuff(BaseInfo self) {
	
		
		this.setAnimIcon("actions/rage");				
		this.setSound("HolyCast");
		this.setResource("actions/rage");                  
		this.setName("Rage");
		
		this.setTime(2);
	
		FatiguedCondition debuff = new FatiguedCondition(self);
		addTrait(debuff);
	}
}