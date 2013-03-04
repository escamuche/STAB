package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Bless_Buff extends Buff {

	public static final String ID="BLESS_BUFF";
	
	public Bless_Buff(BaseInfo atacado) {
	
		
		this.setAnimIcon("actions/ability_druid_naturalperfection");				
		this.setSound("HolyCast");
		this.setResource("actions/ability_druid_naturalperfection");                  
		this.setName("Bless");
		
		this.setTime(10);
	
		Modifier tohit=Modifier.createMod(StabConstants.TOHIT, +1);
		Modifier saves=Modifier.createMod(StabConstants.SAVING, +1);
		
		atacado.addTrait(tohit);
		atacado.addTrait(saves);
		
		}
}
