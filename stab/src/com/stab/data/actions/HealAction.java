package com.stab.data.actions;

import com.stab.data.StabConstants;
import com.stab.data.info.debuff.condition.BleedCondition;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.util.Roll;

public class HealAction extends SelfAction{
	
	public static final String ID="HEALACTION";
	
	public HealAction() {
		
		this.setName("Heal");
		this.setResource("actions/ability_warrior_safeguard");
		//this.setUsableByAI(false);
	
	}

	
	//TODO: campiar por un skillroll
	@Override
	public boolean affect(Info instigator,Info receive) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		if(target.hasTrait(BleedCondition.ID)) {
			int healroll = Roll.d20() + caster.getValue(StabConstants.HEALSKILL);
			if(healroll>14) { 
				target.removeTrait(BleedCondition.ID);
				target.removeTrait(HealAction.ID);
				return true;
			}
			
		}
		
		return false;
	}

}
