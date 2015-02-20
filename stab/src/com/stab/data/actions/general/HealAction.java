package com.stab.data.actions.general;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.model.action.Action;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.info.debuff.condition.BleedCondition;

public class HealAction extends Action  {
	
	public static final String ID="HEALACTION";
	
	public HealAction() {
		setTargetMode(SELF);
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
