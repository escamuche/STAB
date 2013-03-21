package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Rage_Buff extends Buff {
	
	public static final String ID="RAGE_BUFF";
	
	public Rage_Buff(BaseInfo yo) {
		
		this.setAnimIcon("actions/rage");				
		this.setSound("HolyCast");
		this.setResource("actions/rage");                  
		this.setName("Rage");
		
		this.setTime(1);
			
			Modifier cons=new Modifier(StabConstants.CONSTITUTION,StabConstants.MORALMOD,+4);
			Modifier stre=new Modifier(StabConstants.STRENGHT,StabConstants.MORALMOD, +4);
			Modifier will=new Modifier(StabConstants.WILLSAVE,StabConstants.MORALMOD, +2);
			Modifier ac=new Modifier(StabConstants.ARMOR, -2);
			Modifier round=new Modifier(StabConstants.RAGEROUNDSSPENT,+1);
			Modifier hps=new Modifier(StabConstants.MAXHP,+8);
		
			addTrait(cons);
			addTrait(stre);
			addTrait(will);
			addTrait(ac);
			addTrait(round);
			addTrait(hps);
		
			yo.heal(8, true);
		
		}
		
}
