package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Guidance_Buff extends Buff {

	public static final String ID="GUIDANCE_BUFF";
	
	public Guidance_Buff() {
	
		
		this.setAnimIcon("actions/bless");				
		this.setSound("HolyCast");
		this.setResource("actions/bless");                  
		this.setName("Guidance");
		
		this.setCharges(1);
	
		Modifier tohit=new Modifier(StabConstants.TOHIT,StabConstants.COMPETENCEMOD, +1);
		Modifier fsave=new Modifier(StabConstants.FORTITUDESAVE,StabConstants.COMPETENCEMOD, +1);
		Modifier rsave=new Modifier(StabConstants.REFLEXSAVE,StabConstants.COMPETENCEMOD, +1);
		Modifier wsave=new Modifier(StabConstants.WILLSAVE,StabConstants.COMPETENCEMOD, +1);
		
		addTrait(tohit);
		addTrait(fsave);
		addTrait(rsave);
		addTrait(wsave);
				
		}
}