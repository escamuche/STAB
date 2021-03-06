package com.stab.pf.info.buff.spells;

import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.StabConstants;

public class EnlargePerson_Buff extends BuffEffect {

	public static final String ID="ENLARGEPERSON_BUFF";
	
	public EnlargePerson_Buff() {
	
		
		this.setAnimIcon("actions/enlargeperson");				
		this.setSound("HolyCast");
		this.setResource("actions/enlargeperson");                  
		this.setName("Enlarge Person");
	
		Modifier tohit=new Modifier(StabConstants.TOHIT,-1);
		Modifier armor=new Modifier(StabConstants.ARMORMOD,-1);
		Modifier fuerza=new Modifier(StabConstants.STRENGHT,StabConstants.SIZEMOD,+2);
		Modifier destreza=new Modifier(StabConstants.DEXTERITY,StabConstants.SIZEMOD,-2);
		
		addTrait(tohit);
		addTrait(armor);
		addTrait(fuerza);
		addTrait(destreza);
		
		}
}
