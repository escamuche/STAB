package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.TrueStrike_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

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
	public boolean affect(Info instigator,Info receive) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		TrueStrike_Buff buff = new TrueStrike_Buff();
		buff.setTime(1);
		target.addTrait(buff);
		return true;
	}
}