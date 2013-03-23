package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Jump_Buff extends Buff {

	public static final String ID="JUMP_BUFF";
	
	public Jump_Buff(BaseInfo caster,BaseInfo buffed) {
	
		
		this.setAnimIcon("actions/jump");				
		this.setSound("HolyCast");
		this.setResource("actions/jump");                  
		this.setName("Jump");
	
		//asi seria bono a todas las tiradas de acrobacias y deberia ser solo a las de saltar, habria que separa las constantes???
		
			if(caster.getValue(StabConstants.CASTERLEVEL)<5)
			{
				Modifier ca=new Modifier(StabConstants.ACROBATICS,StabConstants.ENHANCEMENTMOD,+10);
				addTrait(ca);
			}
			if(caster.getValue(StabConstants.CASTERLEVEL)<9 && caster.getValue(StabConstants.CASTERLEVEL)>5)
			{
				Modifier ca=new Modifier(StabConstants.ACROBATICS,StabConstants.ENHANCEMENTMOD,+20);
				addTrait(ca);
			}
			if(caster.getValue(StabConstants.CASTERLEVEL)>9)
			{
				Modifier ca=new Modifier(StabConstants.ACROBATICS,StabConstants.ENHANCEMENTMOD,+30);
				addTrait(ca);
			}
			
			}
}