package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Guidance_Buff extends Buff {

	public static final String ID="GUIDANCE_BUFF";
	
	public Guidance_Buff(BaseInfo atacado) {
	
		
		this.setAnimIcon("actions/bless");				
		this.setSound("HolyCast");
		this.setResource("actions/bless");                  
		this.setName("Guidance");
		
		this.setTime(1);
	
		Modifier tohit=Modifier.createMod(StabConstants.TOHIT,StabConstants.COMPETENCEMOD, +1);
		Modifier fsave=Modifier.createMod(StabConstants.FORTITUDESAVE,StabConstants.COMPETENCEMOD, +1);
		Modifier rsave=Modifier.createMod(StabConstants.REFLEXSAVE,StabConstants.COMPETENCEMOD, +1);
		Modifier wsave=Modifier.createMod(StabConstants.WILLSAVE,StabConstants.COMPETENCEMOD, +1);
		
		addTrait(tohit);
		addTrait(fsave);
		addTrait(rsave);
		addTrait(wsave);
		
		}
}