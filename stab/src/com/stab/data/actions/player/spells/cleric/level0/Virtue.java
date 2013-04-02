package com.stab.data.actions.player.spells.cleric.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.spells.Virtue_Buff;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Virtue extends SpellOnTarget{
	
	public static final String ID="VIRTUE";

	@Override
	public boolean execute(Info yo, Info target) {
		
		
		BaseInfo t = (BaseInfo)target;
		
		Virtue_Buff buff = new Virtue_Buff();
		buff.setTime(10);
		t.addTrait(buff);

		return true;
	}
	
	public Virtue() {
		
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(CLOSE);
		setTargetClass(PhysicalToken.class);
		setResource("actions/ability_druid_naturalperfection");
		setName("PurifyFood");
		this.setEffectType(HEAL);
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
	
}