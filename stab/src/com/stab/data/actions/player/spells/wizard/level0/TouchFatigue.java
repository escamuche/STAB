package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.applicable.magic.FortitudeAttack;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class TouchFatigue extends SpellOnTarget{
	
	public static final String ID="TOUCHFATIGUE";

	
	
	public TouchFatigue() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_druid_naturalperfection");
     setName("TouchFatigue");
     this.setEffectType(DEBUFF);
	}
	@Override
	public boolean execute(Info yo, Info target) {
		
		
		BaseInfo i = (BaseInfo) target;
		MagicAttack attack = new MagicAttack(i);
		if(attack.hits()) {
			FortitudeAttack b = new FortitudeAttack(i);
				if(b.hits()){
					FatiguedCondition debuff = new FatiguedCondition();
					debuff.setTime(1);
					i.addTrait(debuff);
					return true;
				}
		}
	return false;
	}

}
