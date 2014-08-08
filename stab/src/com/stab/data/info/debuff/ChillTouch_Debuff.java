package com.stab.data.info.debuff;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;

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
