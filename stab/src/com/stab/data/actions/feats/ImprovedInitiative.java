package com.stab.data.actions.feats;

import com.stab.data.info.buff.ImprovedInitiative_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Buff;

public class ImprovedInitiative extends Buff{
	
	public static final String ID="IMPROVEDINIATIVE";

	
	
	public ImprovedInitiative() {
		
		BaseInfo caster = new BaseInfo();
		ImprovedInitiative_Buff buff = new ImprovedInitiative_Buff(caster );
		this.addTrait(buff);
		//this.setName("Improved Initiative");
		//this.setResource("actions/ability_warrior_safeguard");
		//this.setUsableByAI(false);
	
	}
		
}
