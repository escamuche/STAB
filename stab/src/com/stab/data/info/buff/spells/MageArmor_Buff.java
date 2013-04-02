package com.stab.data.info.buff.spells;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class MageArmor_Buff extends Buff {

	public static final String ID="MAGEARMOR_BUFF";
	
	public MageArmor_Buff() {
	
		
		this.setAnimIcon("actions/magearmor");				
		this.setSound("HolyCast");
		this.setResource("actions/magearmor");                  
		this.setName("MageArmor");
	
		Modifier ca=new Modifier(StabConstants.ARMORDEFENSE,StabConstants.ARMORMOD,+4);
		addTrait(ca);
		}
}
