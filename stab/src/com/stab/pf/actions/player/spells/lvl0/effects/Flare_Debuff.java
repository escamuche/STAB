package com.stab.pf.actions.player.spells.lvl0.effects;

import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DebuffEffect;
import com.stab.pf.StabConstants;

public class Flare_Debuff extends DebuffEffect {

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