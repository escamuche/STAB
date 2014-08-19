package com.stab.data.actions.player.spells.lvl0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.BasicSparkAnimation;
import com.stab.data.info.debuff.condition.DyingCondition;
import com.stab.model.info.BaseInfo;
import com.stab.model.request.basic.ActionRequest;

public class Stabilize extends SpellOnTarget{
	
	public static final String ID="STABILIZE";

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		

		if(target.getHp()<0){
			if(target.hasTrait(DyingCondition.ID)) {
				target.removeTrait(DyingCondition.ID);
			}
		}
		return super.fullEffect(caster, target, point);
	}
	
	public Stabilize() {
	 setLevel(0);
	 setCasterClass(StabConstants.CLERICCASTER);
     setRange(CLOSE);
     setDescriptors(EffectDescriptor.CONJURATION,EffectDescriptor.HEALING);
     setResource("actions/ability_druid_naturalperfection");
     setName("Stabilize");
     this.setEffectType(HEAL);
     this.setDescription("Upon casting this spell, you target a living creature that has –1 or fewer hit points. That creature is automatically stabilized and does not lose any further hit points. If the creature later takes damage, it continues dying normally.");
	}
	
	
	@Override
	protected void playFullEffectAnimation(BaseInfo caster, BaseInfo target,
			Point point, ActionRequest ar) {
		super.playFullEffectAnimation(caster, target, point, ar);
		target.playAnimation(BasicSparkAnimation.ID, "PARTICLE#effects/healing");
	}	
	
}