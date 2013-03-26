package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.TrueStrike_Buff;
import com.stab.model.info.BaseInfo;

public class TrueStrike extends SpellOnSelf{
	
	public static final String ID="TrueStrike";
	
	public TrueStrike() {

		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setResource("actions/truestrike");
     setName("TrueStrike");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean execute(BaseInfo yo) {
		
		BaseInfo caster = (BaseInfo)yo;
		TrueStrike_Buff buff = new TrueStrike_Buff();
		caster.addTrait(buff);
		return true;
	}
}