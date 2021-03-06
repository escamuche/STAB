package com.stab.pf.info.buff.spells;

import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.StabConstants;

public class Bless_Buff extends BuffEffect {

	public static final String ID="BLESS_BUFF";
	
	public Bless_Buff() {

		
		this.setAnimIcon("actions/bless");				
		this.setSound("HolyCast");
		this.setResource("actions/bless");                  
		this.setName("Bless");
	
		Modifier tohit=new Modifier(StabConstants.TOHIT,StabConstants.SACREDMOD, +1);
		Modifier savef=new Modifier(StabConstants.FORTITUDESAVE,StabConstants.SACREDMOD, +1);
		Modifier saver=new Modifier(StabConstants.REFLEXSAVE,StabConstants.SACREDMOD, +1);
		Modifier savew=new Modifier(StabConstants.WILLSAVE,StabConstants.SACREDMOD, +1);
		
		addTrait(tohit);
		addTrait(savef);
		addTrait(saver);
		addTrait(savew);
		
		}
}
