package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.applicable.magic.FortitudeAttack;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.data.info.buff.spells.Jump_Buff;
import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class TouchFatigue extends SpellOnTarget{
	
	public static final String ID="TOUCHFATIGUE";

	
	
	public TouchFatigue() {
		
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/ability_druid_naturalperfection");
		setName("TouchFatigue");
		this.setEffectType(DEBUFF);
		setRange(TOUCH);
	}
	@Override
	public boolean affect(Info instigator, Info receptor) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int cl = getCasterLevel(caster);
		
		

		MagicAttack attack = new MagicAttack(caster);
		if(attack.hits()) {
			FortitudeAttack b = new FortitudeAttack(caster);
				if(b.hits()){
					FatiguedCondition debuff = new FatiguedCondition();
					debuff.setTime(cl);
					target.addTrait(debuff);
					return true;
				}
		}
	return false;
	}

}
