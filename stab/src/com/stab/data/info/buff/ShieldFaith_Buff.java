package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class ShieldFaith_Buff extends Buff {

	public static final String ID="SHIELDFAITH_BUFF";
	
	public ShieldFaith_Buff(BaseInfo atacante) {
	
		
		this.setAnimIcon("actions/shieldfaith");				
		this.setSound("HolyCast");
		this.setResource("actions/shieldfaith");                  
		this.setName("Shield of Faith");
		
		this.setTime(10);
	
		Modifier ca=Modifier.createMod(StabConstants.ARMOR,StabConstants.DEFLECTIONMOD,+2);
		addTrait(ca);
		}
}