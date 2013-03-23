package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Identify_Buff extends Buff {

	public static final String ID="IDENTIFY_BUFF";
	
	public Identify_Buff(BaseInfo atacante) {
	
		
		this.setAnimIcon("actions/magearmor");				
		this.setSound("HolyCast");
		this.setResource("actions/magearmor");                  
		this.setName("Identify");
		
		this.setTime(3);
	
		Modifier ca=new Modifier(StabConstants.SPELLCRAFT,StabConstants.ENHANCEMENTMOD,+10);
		addTrait(ca);
		}
}