package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Expertise_Buff extends Buff {

	public static final String ID="EXPERTISE_BUFF";
	
	public Expertise_Buff() {
	
		this.setAnimIcon("actions/ability_warrior_safeguard");				
	//	this.setAnimIcon("PARTICLE#test#res/particles/ability_backstab");
		this.setSound("HolyCast");
		this.setResource("actions/ability_warrior_safeguard");                  
		this.setName("Expertise");
		
		this.setPermanent();
	
		Modifier caexpertise= Modifier.createMod(StabConstants.ACTIVEDEFENSE,StabConstants.DODGEMOD, +1);
		Modifier tohitexpertise=Modifier.createMod(StabConstants.TOHIT,-1);
		Modifier tohitrangedexpertise=Modifier.createMod(StabConstants.TOHITRANGED, -1);
		
		addTrait(caexpertise);
		addTrait(tohitexpertise);
		addTrait(tohitrangedexpertise);
		}
}
