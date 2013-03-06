package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class TrueStrike_Buff extends Buff {

	public static final String ID="TRUESTRIKE_BUFF";
	
	public TrueStrike_Buff(BaseInfo atacante) {
	
		
		this.setAnimIcon("actions/ability_shaman_watershield");				
		this.setSound("HolyCast");
		this.setResource("actions/ability_shaman_watershield");                  
		this.setName("TrueStrike");
		
		this.setTime(1);
	
		Modifier hit=Modifier.createMod(StabConstants.TOHIT, +20);
		Modifier hitranged=Modifier.createMod(StabConstants.TOHITRANGED, +20);
		addTrait(hit);
		addTrait(hitranged);
		}
}