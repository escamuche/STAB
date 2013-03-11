package com.stab.data.info.buff;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Buff;

public class Toughness_Buff extends Buff {

	public static final String ID="TOUGHNESS_BUFF";
	
	public Toughness_Buff(BaseInfo buffed) {
	
		
		//this.setAnimIcon("actions/enlargeperson");				
		//this.setSound("HolyCast");
		//this.setResource("actions/enlargeperson");                  
		this.setName("Toughness");
		
		this.setPermanent();
	
		buffed.setHp(+3);
		
		}
}
