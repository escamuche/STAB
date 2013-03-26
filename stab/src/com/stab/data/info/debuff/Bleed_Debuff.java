package com.stab.data.info.debuff;

import com.stab.model.info.trait.base.Buff;

public class Bleed_Debuff extends Buff {

	public static final String ID="BLEED_DEBUFF";
	
	public Bleed_Debuff() {
	
		
		this.setAnimIcon("actions/bleed");				
		this.setSound("HolyCast");
		this.setResource("actions/bleed");                  
		this.setName("Bleed");
	
	}
}