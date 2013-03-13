package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;
import com.stab.model.request.basic.ActionRequest;
import com.stab.util.Roll;

public class MagicStone_Buff extends Buff {

	public static final String ID="MAGICSTONE_BUFF";
	
	public MagicStone_Buff(BaseInfo caster) {
	
		this.setAnimIcon("actions/magicstone");				
		this.setSound("HolyCast");
		this.setResource("actions/magicstone");                  
		this.setName("Magic Stone");
		
		this.setTime(1);
	
		Modifier tohitranged=Modifier.createMod(StabConstants.TOHITRANGED,StabConstants.ENHANCEMENTMOD, +1);
		Modifier damageranged=Modifier.createMod(StabConstants.DAMAGERANGED,StabConstants.ENHANCEMENTMOD,Roll.d6()+2);
		
		
		addTrait(tohitranged);
		addTrait(damageranged);
		}
	
}
