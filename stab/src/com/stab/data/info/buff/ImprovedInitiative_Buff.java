package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class ImprovedInitiative_Buff extends Buff {

	public static final String ID="IMPROVEDINITIATIVE_BUFF";
	
	public ImprovedInitiative_Buff(BaseInfo caster) {
	
		
		this.setAnimIcon("actions/divinefavor");				
		this.setSound("HolyCast");
		this.setResource("actions/divinefavor");                  
		this.setName("Improved Initiative");
		
		this.setPermanent();
	
		Modifier iniciativa=Modifier.createMod(StabConstants.INICIATIVEMOD, +4);
		
		addTrait(iniciativa);
		
		}
}
