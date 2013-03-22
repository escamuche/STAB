package com.stab.data.actions;

import com.stab.data.StabConstants;
import com.stab.data.info.debuff.condition.BleedCondition;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.util.Roll;

public class HealAction extends SelfAction{
	
	public static final String ID="HEALACTION";
	
	public HealAction() {
		
		this.setName("Heal");
		this.setResource("actions/ability_warrior_safeguard");
		//this.setUsableByAI(false);
	
	}

	@Override
	public boolean execute(BaseInfo self) {
		
		if(self.hasTrait(BleedCondition.ID)) {
			int healroll = Roll.d20() + self.getValue(StabConstants.HEALSKILL);
			if(healroll>14) { 
				self.removeTrait(BleedCondition.ID);
				return true;
			}
			
		}
		
		return false;
	}

}
