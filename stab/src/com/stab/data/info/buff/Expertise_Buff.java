package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;

public class Expertise_Buff extends BuffEffect {

	public static final String ID="EXPERTISE_BUFF";
	
	public Expertise_Buff(int bab) {
	
		this.setAnimIcon("actions/ability_warrior_safeguard");				
	//	this.setAnimIcon("PARTICLE#test#res/particles/ability_backstab");
		this.setSound("HolyCast");
		this.setResource("actions/ability_warrior_safeguard");                  
		this.setName("Expertise");
		
		this.setPermanent();
		
		int v = (bab/4)+1;
		Modifier daño = new Modifier(StabConstants.DAMAGE, v*2);
		Modifier hit = new Modifier(StabConstants.TOHIT, v);
		addTrait(daño);
		addTrait(hit);
		
	}
}
