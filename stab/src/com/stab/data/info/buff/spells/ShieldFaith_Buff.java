package com.stab.data.info.buff.spells;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;

public class ShieldFaith_Buff extends BuffEffect {

	public static final String ID="SHIELDFAITH_BUFF";
	
	public ShieldFaith_Buff() {
	
		
		this.setAnimIcon("actions/shieldfaith");				
		this.setSound("HolyCast");
		this.setResource("actions/shieldfaith");                  
		this.setName("Shield of Faith");
	
		Modifier ca=new Modifier(StabConstants.ARMORDEFENSE,StabConstants.DEFLECTIONMOD,+2);
		addTrait(ca);
		}
}