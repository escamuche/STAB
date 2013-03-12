package com.stab.data.actions.feats;

import com.stab.data.info.buff.ImprovedInitiative_Buff;
import com.stab.data.info.buff.SkillFocusPerception_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Buff;

public class SkillFocusPerception extends Buff{
	
	public static final String ID="SKILLFOCUS_PERCEPTION";

	
	
	public SkillFocusPerception() {
		
		BaseInfo caster = new BaseInfo();
		SkillFocusPerception_Buff buff = new SkillFocusPerception_Buff(caster );
		this.addTrait(buff);
		//this.setName("Improved Initiative");
		//this.setResource("actions/ability_warrior_safeguard");
		//this.setUsableByAI(false);
	
	}
		
}