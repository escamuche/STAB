package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.condition.DazedCondition;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Command extends SpellOnTarget{
	
	public static final String ID="COMMAND";

	
	public Command() {
		
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/command");
		setName("Command");
		this.setEffectType(DEBUFF);
		setRange(CLOSE);
	}
	
	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo t = (BaseInfo) target;
		BaseInfo caster=(BaseInfo)yo;
		DazedCondition d = new DazedCondition();
		
	
		d.setTime(1);
		t.addTrait(d);
		return true;
		
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 6;
	}
}
