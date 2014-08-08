package com.stab.data.info.buff.spells;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;

public class DivineFavor_Buff extends BuffEffect {

	public static final String ID="DIVINEFAVOR_BUFF";
	
	public DivineFavor_Buff(int cl) {
	
		
		this.setAnimIcon("actions/divinefavor");				
		this.setSound("HolyCast");
		this.setResource("actions/divinefavor");                  
		this.setName("Divine Favor");
	
		int bono = (cl/3)+1;
		if(bono > 3)
			bono=3;
		
		Modifier tohit=new Modifier(StabConstants.TOHIT,StabConstants.LUCKMOD, bono);
		Modifier tohitranged=new Modifier(StabConstants.TOHITRANGED,StabConstants.LUCKMOD, bono);
		Modifier damage=new Modifier(StabConstants.DAMAGE,StabConstants.LUCKMOD, bono);
		Modifier damageranged=new Modifier(StabConstants.DAMAGERANGED,StabConstants.LUCKMOD, bono);
		
		addTrait(tohit);
		addTrait(tohitranged);
		addTrait(damage);
		addTrait(damageranged);
		
		}
}