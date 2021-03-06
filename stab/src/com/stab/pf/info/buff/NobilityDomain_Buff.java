package com.stab.pf.info.buff;

import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.StabConstants;
import com.stab.pf.info.trait.AllSkillsModifier;

public class NobilityDomain_Buff extends BuffEffect {

	public static final String ID="NOBILITYDOMAIN_BUFF";
	
	public NobilityDomain_Buff() {
	
		
		this.setAnimIcon("actions/nobility");				
		this.setSound("HolyCast");
		this.setResource("actions/nobility");                  
		this.setName("Nobility Domain");
	
		Modifier tohit=new Modifier(StabConstants.TOHIT,StabConstants.MORALMOD, +2);
		Modifier savef=new Modifier(StabConstants.FORTITUDESAVE,StabConstants.MORALMOD, +2);
		Modifier saver=new Modifier(StabConstants.REFLEXSAVE,StabConstants.MORALMOD, +2);
		Modifier savew=new Modifier(StabConstants.WILLSAVE,StabConstants.MORALMOD, +2);
		AllSkillsModifier s = new AllSkillsModifier(StabConstants.MORALMOD, +2);
				
		addTrait(tohit);
		addTrait(savef);
		addTrait(saver);
		addTrait(savew);
		addTrait(s);
		
		}
}
