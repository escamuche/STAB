package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnSelf;
import com.stab.data.info.buff.spells.TrueStrike_Buff;
import com.stab.model.info.BaseInfo;

public class TrueStrike extends SpellOnSelf{
	
	public static final String ID="TrueStrike";
	
	public TrueStrike() {

		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
     setResource("actions/truestrike");
     setName("TrueStrike");
     this.setEffectType(BUFF);
     this.setDescription("You gain temporary, intuitive insight into the immediate future during your next attack. Your next single attack roll (if it is made before the end of the next round) gains a +20 insight bonus. Additionally, you are not affected by the miss chance that applies to attackers trying to strike a concealed target.");
	}

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		TrueStrike_Buff buff = new TrueStrike_Buff();
		buff.setTime(1);
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}
}