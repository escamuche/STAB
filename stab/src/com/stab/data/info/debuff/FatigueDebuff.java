package com.stab.data.info.debuff;

import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.info.trait.base.DebuffEffect;

public class FatigueDebuff extends DebuffEffect{
	public static final String ID="FATIGUE_DEBUFF";
	
	public FatigueDebuff() {
	
		
		this.setAnimIcon("actions/fatigued");				
		this.setSound("HolyCast");
		this.setResource("actions/fatigued");                  
		this.setName("Fatigued");
		this.setUnique(true);

		
		FatiguedCondition debuff = new FatiguedCondition(); 
		addTrait(debuff);	
	}
}
