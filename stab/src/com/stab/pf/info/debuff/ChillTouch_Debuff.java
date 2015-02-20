package com.stab.pf.info.debuff;

import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.StabConstants;

public class ChillTouch_Debuff extends BuffEffect {

	public static final String ID="CHILDTOUCH_DEBUFF";
	
	public ChillTouch_Debuff() {
	
		this.setAnimIcon("actions/chilltouch");				
		this.setSound("HolyCast");
		this.setResource("actions/childtouch");                  
		this.setName("ChildTouch");
	
		Modifier tohit=new Modifier(StabConstants.STRENGHT, -1);
		addTrait(tohit);
	}
}
