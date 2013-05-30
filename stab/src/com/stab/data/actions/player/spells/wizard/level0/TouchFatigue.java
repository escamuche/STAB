package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.info.BaseInfo;

public class TouchFatigue extends SpellOnTarget{
	
	public static final String ID="TOUCHFATIGUE";

	
	
	public TouchFatigue() {
		
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		
		setResource("actions/ability_druid_naturalperfection");
		setName("TouchFatigue");
		this.setEffectType(DEBUFF);
		setRange(TOUCH);
		this.setDescription("You channel negative energy through your touch, fatiguing the target. You must succeed on a touch attack to strike a target. The subject is immediately fatigued for the spell's duration. This spell has no effect on a creature that is already fatigued. Unlike with normal fatigue, the effect ends as soon as the spell's duration expires.");
		this.setSave(StabConstants.FORTITUDESAVE);
		}
@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	int cl = getCasterLevel(caster);
	FatiguedCondition debuff = new FatiguedCondition();
	debuff.setTime(cl);
	target.addTrait(debuff);
	return super.fullEffect(caster, target, point);
}

}
