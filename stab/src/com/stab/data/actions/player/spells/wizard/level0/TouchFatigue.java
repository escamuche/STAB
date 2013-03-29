package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.applicable.magic.FortitudeAttack;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.data.info.buff.Jump_Buff;
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
	public boolean execute(Info caster, Info target) {
		
		
		BaseInfo i = (BaseInfo) target;
		BaseInfo c = (BaseInfo) caster;
		int cl = getCasterLevel(i);
		
		

		MagicAttack attack = new MagicAttack(i);
		if(attack.hits()) {
			FortitudeAttack b = new FortitudeAttack(i);
				if(b.hits()){
					FatiguedCondition debuff = new FatiguedCondition();
					debuff.setTime(cl);
					i.addTrait(debuff);
					return true;
				}
		}
	return false;
	}

}
