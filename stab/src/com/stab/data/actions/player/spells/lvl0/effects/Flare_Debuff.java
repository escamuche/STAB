package com.stab.data.actions.player.spells.lvl0.effects;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;

public class Flare_Debuff extends BuffEffect {

	public static final String ID="FLARE_DEBUFF";
	
	public Flare_Debuff() {
	
		
		this.setAnimIcon("actions/flare");				
		this.setSound("HolyCast");
		this.setResource("actions/flare");                  
		this.setName("Flare");
	
		Modifier tohit=new Modifier(StabConstants.TOHIT, -1);
		addTrait(tohit);
	}
}