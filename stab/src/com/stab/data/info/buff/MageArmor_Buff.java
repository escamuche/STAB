package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class MageArmor_Buff extends Buff {

	public static final String ID="MAGEARMOR_BUFF";
	
	public MageArmor_Buff(BaseInfo atacante) {
	
		
		this.setAnimIcon("actions/ability_shaman_watershield");				
		this.setSound("HolyCast");
		this.setResource("actions/ability_shaman_watershield");                  
		this.setName("MageArmor");
		
		this.setTime(60);
	
		Modifier ca=Modifier.createMod(StabConstants.ARMOR,StabConstants.ARMORMOD,+4);
		addTrait(ca);
		}
}
