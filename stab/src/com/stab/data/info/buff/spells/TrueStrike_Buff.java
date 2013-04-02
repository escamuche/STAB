package com.stab.data.info.buff.spells;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class TrueStrike_Buff extends Buff {

	public static final String ID="TRUESTRIKE_BUFF";
	
	public TrueStrike_Buff() {
	
		
		this.setAnimIcon("actions/truestrike");				
		this.setSound("HolyCast");
		this.setResource("actions/truestrike");                  
		this.setName("TrueStrike");
	
		Modifier hit=new Modifier(StabConstants.TOHIT,StabConstants.INSIGHTMOD,+20);
		Modifier hitranged=new Modifier(StabConstants.TOHITRANGED,StabConstants.INSIGHTMOD,+20);
		addTrait(hit);
		addTrait(hitranged);
		}
}