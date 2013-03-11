package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class EntropicShield_Buff extends Buff {

	public static final String ID="ENTROPICSHIELD_BUFF";
	
	public EntropicShield_Buff(BaseInfo caster) {
	
		
		this.setAnimIcon("actions/ability_shaman_watershield");				
		this.setSound("HolyCast");
		this.setResource("actions/ability_shaman_watershield");                  
		this.setName("Entropic Shield");
		
		this.setTime(10);
		//falta comprobacion y buff
		}
}
