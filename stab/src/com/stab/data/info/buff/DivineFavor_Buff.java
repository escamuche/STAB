package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class DivineFavor_Buff extends Buff {

	public static final String ID="DIVINEFAVOR_BUFF";
	
	public DivineFavor_Buff(BaseInfo caster) {
	
		
		this.setAnimIcon("actions/divinefavor");				
		this.setSound("HolyCast");
		this.setResource("actions/divinefavor");                  
		this.setName("Divine Favor");
		
		this.setTime(10);
	
		Modifier tohit=new Modifier(StabConstants.TOHIT,StabConstants.LUCKMOD, +1);
		Modifier tohitranged=new Modifier(StabConstants.TOHITRANGED,StabConstants.LUCKMOD, +1);
		Modifier damage=new Modifier(StabConstants.DAMAGE,StabConstants.LUCKMOD, +1);
		Modifier damageranged=new Modifier(StabConstants.DAMAGERANGED,StabConstants.LUCKMOD, +1);
		
		addTrait(tohit);
		addTrait(tohitranged);
		addTrait(damage);
		addTrait(damageranged);
		
		}
}