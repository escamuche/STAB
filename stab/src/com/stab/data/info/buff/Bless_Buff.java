package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Bless_Buff extends Buff {

	public static final String ID="BLESS_BUFF";
	
	public Bless_Buff(BaseInfo atacado) {
	
		
		this.setAnimIcon("actions/bless");				
		this.setSound("HolyCast");
		this.setResource("actions/bless");                  
		this.setName("Bless");
		
		this.setTime(10);
	
		Modifier tohit=Modifier.createMod(StabConstants.TOHIT,StabConstants.SACREDMOD, +1);
		Modifier savef=Modifier.createMod(StabConstants.FORTITUDESAVE,StabConstants.SACREDMOD, +1);
		Modifier saver=Modifier.createMod(StabConstants.REFLEXSAVE,StabConstants.SACREDMOD, +1);
		Modifier savew=Modifier.createMod(StabConstants.WILLSAVE,StabConstants.SACREDMOD, +1);
		
		addTrait(tohit);
		addTrait(savef);
		addTrait(saver);
		addTrait(savew);
		
		}
}
