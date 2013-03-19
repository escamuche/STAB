package com.stab.data.info.buff;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Buff;

public class ExpeditiousRetreat_Buff extends Buff {

	public static final String ID="TRUESTRIKE_BUFF";
	
	public ExpeditiousRetreat_Buff(BaseInfo caster) {
	
		
		this.setAnimIcon("expeditiousretreat");				
		this.setSound("HolyCast");
		this.setResource("expeditiousretreat");                  
		this.setName("Expeditious Retreat");
		
		this.setTime(10);
	
		}
}
