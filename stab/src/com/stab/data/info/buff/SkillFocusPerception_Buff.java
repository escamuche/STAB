package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class SkillFocusPerception_Buff extends Buff {

	public static final String ID="SKILLFOCUSPERCEPTION_BUFF";
	
	public SkillFocusPerception_Buff(BaseInfo caster) {
	
		
		this.setAnimIcon("actions/divinefavor");				
		this.setSound("HolyCast");
		this.setResource("actions/divinefavor");                  
		this.setName("Divine Favor");
		
		this.setPermanent();
	
		Modifier buff=Modifier.createMod(StabConstants.PERCEPTION,+3);
				
		addTrait(buff);
		
		}
}