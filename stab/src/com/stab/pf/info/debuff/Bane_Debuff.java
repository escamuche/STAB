package com.stab.pf.info.debuff;

import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.StabConstants;

public class Bane_Debuff extends BuffEffect {

	public static final String ID="BANE_DEBUFF";
	
	public Bane_Debuff() {

		this.setAnimIcon("actions/bane");				
		this.setSound("HolyCast");
		this.setResource("actions/bane");                  
		this.setName("Bane");
	
		Modifier tohit=new Modifier(StabConstants.TOHIT, -1);
		//falta el -1 contra miedo
		addTrait(tohit);
	}
}