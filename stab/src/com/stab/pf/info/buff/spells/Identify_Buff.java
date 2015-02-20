package com.stab.pf.info.buff.spells;

import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.StabConstants;

public class Identify_Buff extends BuffEffect {

	public static final String ID="IDENTIFY_BUFF";
	
	public Identify_Buff() {
	
		
		this.setAnimIcon("actions/magearmor");				
		this.setSound("HolyCast");
		this.setResource("actions/magearmor");                  
		this.setName("Identify");
	
		Modifier ca=new Modifier(StabConstants.SPELLCRAFT,StabConstants.ENHANCEMENTMOD,+10);
		addTrait(ca);
		}
}