package com.stab.data.rules;

import com.stab.common.events.Condition;
import com.stab.common.events.ManagedEvent;
import com.stab.model.basic.scenes.event.InfoEvent;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.util.StabUtils;

public class InfoSkillRollContidion extends Condition{

	String skill;
	int dc;
	
	public InfoSkillRollContidion(String skill,int dc) {
		this.skill=skill;
		this.dc=dc;
	}
	
	@Override
	public boolean check(ManagedEvent e) {
		if (e instanceof InfoEvent){
			BaseInfo i=(BaseInfo)((InfoEvent)e).getInfo();
			SkillRoll sk=StabUtils.getGameLogic().getSkillRoll(i,skill,dc);
			sk.check();
			return sk.success();
		}
		return false;
	}
}
