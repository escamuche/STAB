package com.stab.data.info.debuff;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Debuff;

public class Lullaby_Debuff extends Debuff{
	
	public static final String ID="LULLABY_DEBUFF";
	
	public Lullaby_Debuff() {

		this.setAnimIcon("actions/lullaby");				
		this.setSound("HolyCast");
		this.setResource("actions/lullaby");                  
		this.setName("Lullaby");
	
		Modifier a=new Modifier(StabConstants.PERCEPTION, -5);
		//falta el -2 contra sueño
		addTrait(a);
	}
}
