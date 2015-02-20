package com.stab.pf.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTarget;
import com.stab.pf.info.debuff.condition.DazedCondition;

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
		 this.setLevel(1);
	}
	
	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		DazedCondition d = new DazedCondition();
		d.setTime(1);
		target.addTrait(d);
		return super.fullEffect(caster, target, point);
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 6;
	}
}
