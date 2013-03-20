package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class EnlargePerson_Buff extends Buff {

	public static final String ID="ENLARGEPERSON_BUFF";
	
	public EnlargePerson_Buff(BaseInfo buffed) {
	
		
		this.setAnimIcon("actions/enlargeperson");				
		this.setSound("HolyCast");
		this.setResource("actions/enlargeperson");                  
		this.setName("Enlarge Person");
		
		this.setTime(10);
	
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
