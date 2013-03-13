package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class TrueStrike_Buff extends Buff {

	public static final String ID="TRUESTRIKE_BUFF";
	
	public TrueStrike_Buff(BaseInfo caster) {
	
		
		this.setAnimIcon("actions/truestrike");				
		this.setSound("HolyCast");
		this.setResource("actions/truestrike");                  
		this.setName("TrueStrike");
		
		this.setTime(1);
	
		Modifier hit=Modifier.createMod(StabConstants.TOHIT,StabConstants.INSIGHTMOD,+20);
		Modifier hitranged=Modifier.createMod(StabConstants.TOHITRANGED,StabConstants.INSIGHTMOD,+20);
		addTrait(hit);
		addTrait(hitranged);
		}
}