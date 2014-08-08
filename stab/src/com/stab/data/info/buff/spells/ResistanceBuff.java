package com.stab.data.info.buff.spells;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;

public class ResistanceBuff extends BuffEffect {

	public static final String ID="RESISTANCE_BUFF";
	
	public ResistanceBuff() {
	
		
		this.setAnimIcon("actions/nightshield");				
		this.setSound("HolyCast");
		this.setResource("actions/nightshield");                  
		this.setName("Resistance");
	
		Modifier fortsave=new Modifier(StabConstants.FORTITUDESAVE,StabConstants.RESISTANCEMOD,+1);
		Modifier refsave=new Modifier(StabConstants.REFLEXSAVE, +1);
		Modifier willsave=new Modifier(StabConstants.WILLSAVE, +1);
		
		addTrait(fortsave);
		addTrait(refsave);
		addTrait(willsave);
		
		}
}