package com.stab.data.info.debuff;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class RayEnfeeblement_Debuff extends Buff {

	public static final String ID="RAYENFEEBLEMENT_DEBUFF";
	
	public RayEnfeeblement_Debuff(int amount) {

		this.setAnimIcon("actions/rayenfeeblement");				
		this.setSound("HolyCast");
		this.setResource("actions/rayenfeeblement");                  
		this.setName("Ray of Enfeeblement");
	
		Modifier str=new Modifier(StabConstants.STRENGHT, -amount);
		addTrait(str);
	}
}
