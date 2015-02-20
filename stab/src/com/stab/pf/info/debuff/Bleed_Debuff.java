package com.stab.pf.info.debuff;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.info.debuff.condition.BleedCondition;

public class Bleed_Debuff extends BuffEffect {

	public static final String ID="BLEED_DEBUFF";
	
	public Bleed_Debuff() {
	
		
		this.setAnimIcon("actions/bleed");				
		this.setSound("HolyCast");
		this.setResource("actions/bleed");                  
		this.setName("Bleed");
		
		BaseInfo t = (BaseInfo) getTarget();
		t.addTrait(new BleedCondition(t,1));
	}
	

}