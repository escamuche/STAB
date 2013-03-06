package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class ResistanceBuff extends Buff {

	public static final String ID="RESISTANCE_BUFF";
	
	public ResistanceBuff(BaseInfo Bufado) {
	
		
		this.setAnimIcon("actions/ability_druid_naturalperfection");				
		this.setSound("HolyCast");
		this.setResource("actions/ability_druid_naturalperfection");                  
		this.setName("Resistance");
		
		this.setTime(10);
	
		Modifier fortsave=Modifier.createMod(StabConstants.FORTITUDESAVE, +1);
		Modifier refsave=Modifier.createMod(StabConstants.REFLEXSAVE, +1);
		Modifier willsave=Modifier.createMod(StabConstants.WILLSAVE, +1);
		
		addTrait(fortsave);
		addTrait(refsave);
		addTrait(willsave);
		
		}
}