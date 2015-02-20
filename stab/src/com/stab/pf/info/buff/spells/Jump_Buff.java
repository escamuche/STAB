package com.stab.pf.info.buff.spells;

import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;
import com.stab.pf.StabConstants;

public class Jump_Buff extends BuffEffect {

	public static final String ID="JUMP_BUFF";
	
	public Jump_Buff(int cl) {
	
		
		this.setAnimIcon("actions/jump");				
		this.setSound("HolyCast");
		this.setResource("actions/jump");                  
		this.setName("Jump");
	
		//asi seria bono a todas las tiradas de acrobacias y deberia ser solo a las de saltar, habria que separa las constantes???
		
			if(cl<=5)
			{
				Modifier ca=new Modifier(StabConstants.ACROBATICS,StabConstants.ENHANCEMENTMOD,+10);
				addTrait(ca);
			}
			if(cl<9 && cl>5)
			{
				Modifier ca=new Modifier(StabConstants.ACROBATICS,StabConstants.ENHANCEMENTMOD,+20);
				addTrait(ca);
			}
			if(cl>=9)
			{
				Modifier ca=new Modifier(StabConstants.ACROBATICS,StabConstants.ENHANCEMENTMOD,+30);
				addTrait(ca);
			}
			
			}
}