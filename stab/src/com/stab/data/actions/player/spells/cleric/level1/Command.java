package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.condition.DazedCondition;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Command extends SpellOnTarget{
	
	public static final String ID="COMMAND";

	
	public Command() {
		
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		
		setResource("actions/command");
		setName("Command");
		this.setEffectType(DEBUFF);
		setRange(CLOSE);
		setDescription("You give the subject a single command, which it obeys to the best of its ability at its earliest opportunity. Halt: The subject stands in place for 1 round. It may not take any actions but is not considered helpless.");
	}
	
	@Override
	public boolean affect(Info instigator, Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		DazedCondition d = new DazedCondition();
		
	
		d.setTime(1);
		target.addTrait(d);
		return true;
		
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 6;
	}
}
