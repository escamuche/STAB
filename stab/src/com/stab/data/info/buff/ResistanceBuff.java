package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class ResistanceBuff extends Buff {

	public static final String ID="RESISTANCE_BUFF";
	
	public ResistanceBuff(BaseInfo Bufado) {
	
		
		this.setAnimIcon("actions/nightshield");				
		this.setSound("HolyCast");
		this.setResource("actions/nightshield");                  
		this.setName("Resistance");
		
		this.setTime(10);
	
		Modifier fortsave=new Modifier(StabConstants.FORTITUDESAVE,StabConstants.RESISTANCEMOD,+1);
		Modifier refsave=new Modifier(StabConstants.REFLEXSAVE, +1);
		Modifier willsave=new Modifier(StabConstants.WILLSAVE, +1);
		
		addTrait(fortsave);
		addTrait(refsave);
		addTrait(willsave);
		
		}
}