package com.stab.data.actions.general;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.info.debuff.condition.BleedCondition;
import com.stab.model.action.Action;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class HealAction extends Action implements SelfAction{
	
	public static final String ID="HEALACTION";
	
	public HealAction() {
		
		this.setName("Heal");
		this.setResource("actions/ability_warrior_safeguard");
		//this.setUsableByAI(false);
	
	}

	
	//TODO: campiar por un skillroll
	@Override
	public int affect(Info instigator,Info receive,Point point, ActionRequest ar) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		if(target.hasTrait(BleedCondition.ID)) {
			int healroll = Roll.d20() + caster.getValue(StabConstants.HEALSKILL);
			if(healroll>14) { 
				target.removeTrait(BleedCondition.ID);
				target.removeTrait(HealAction.ID);
				return OK;
			}
			
		}
		
		return FAIL;
	}

}
