package com.stab.data.info.debuff;

import com.stab.data.info.debuff.condition.BleedCondition;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Buff;

public class Bleed_Debuff extends Buff {

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