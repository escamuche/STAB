package com.stab.pf.info.player.abilities;

import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.StabConstants;

public class NatureSense extends BuffEffect {
	
	public static final String ID="NATURESENSE";
	
	public NatureSense() {
				         
		this.setUnique(true);
		this.setPermanent();
		
		Modifier n = new Modifier(StabConstants.KNOWLEDGENATURE, +2);
		Modifier s = new Modifier(StabConstants.SURVIVAL, +2);
		
		this.addTrait(n);
		this.addTrait(s);
		
	}
}