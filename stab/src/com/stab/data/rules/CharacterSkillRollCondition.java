package com.stab.data.rules;

import com.stab.common.events.Condition;
import com.stab.common.events.ManagedEvent;
import com.stab.model.Player;
import com.stab.model.basic.scenes.event.PlayerEvent;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.SkillRoll;

public class CharacterSkillRollCondition  extends Condition{

	String skill;
	int dc;
	
	public CharacterSkillRollCondition(String skill,int dc) {
		this.skill=skill;
		this.dc=dc;
	}
	
	@Override
	public boolean check(ManagedEvent e) {
		if (e instanceof PlayerEvent){
			Player p=((PlayerEvent)e).getPlayer();
			SkillRoll sk= new SkillRoll((BaseInfo)p.getCharacter(),skill,dc);
			sk.check();
			return sk.success();
		}
		return false;
	}

}
