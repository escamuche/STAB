package com.stab.data.info.buff.spells;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;
import com.stab.util.Roll;

public class MagicStone_Buff extends Buff {

	public static final String ID="MAGICSTONE_BUFF";
	
	public MagicStone_Buff() {
	
		this.setAnimIcon("actions/magicstone");				
		this.setSound("HolyCast");
		this.setResource("actions/magicstone");                  
		this.setName("Magic Stone");
	
		Modifier tohitranged=new Modifier(StabConstants.TOHITRANGED,StabConstants.ENHANCEMENTMOD, +1);
		Modifier damageranged=new Modifier(StabConstants.DAMAGERANGED,StabConstants.ENHANCEMENTMOD,Roll.d6()+2);
		
		
		addTrait(tohitranged);
		addTrait(damageranged);
		}
	
}
