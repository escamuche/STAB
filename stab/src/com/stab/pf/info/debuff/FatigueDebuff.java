package com.stab.pf.info.debuff;

import com.stab.model.info.trait.base.DebuffEffect;
import com.stab.pf.info.debuff.condition.FatiguedCondition;

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
