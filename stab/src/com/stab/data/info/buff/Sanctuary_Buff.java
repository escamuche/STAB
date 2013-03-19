package com.stab.data.info.buff;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Buff;

public class Sanctuary_Buff extends Buff {

	public static final String ID="SANCTUARY_BUFF";
	
	public Sanctuary_Buff(BaseInfo caster) {
	
		
		this.setAnimIcon("actions/divinefavor");				
		this.setSound("HolyCast");
		this.setResource("actions/divinefavor");                  
		this.setName("Sanctuary");
		
		this.setTime(1);
		
		}
}
