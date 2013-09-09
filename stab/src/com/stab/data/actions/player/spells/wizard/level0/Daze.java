package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.BasicSparkAnimation;
import com.stab.data.info.debuff.condition.DazedCondition;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class Daze extends SpellOnTarget{
	
	public static final String ID="DAZE";

	
	public Daze() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setDescriptors(EffectDescriptor.COMPULSION,EffectDescriptor.MIND_AFFECTING,EffectDescriptor.STUN);
		setResource("actions/ability_druid_naturalperfection");
		setName("Daze");
		this.setEffectType(DEBUFF);
		setRange(CLOSE);
		this.setDescription("This spell clouds the mind of a humanoid creature with 4 or fewer Hit Dice so that it takes no actions. Humanoids of 5 or more HD are not affected. A dazed subject is not stunned, so attackers get no special advantage against it. After a creature has been dazed by this spell, it is immune to the effects of this spell for 1 minute.");
		this.setSave(StabConstants.WILLSAVE);
	}

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	DazedCondition buff = new DazedCondition();
	buff.setTime(1);
	target.addTrait(buff);
	return super.fullEffect(caster, target, point);
}

	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 5;
	}
	
	
	@Override
	protected void playExecuteActionAnimation(Info caster, Info target,
			Point pos,ActionRequest ar) {
		super.playExecuteActionAnimation(caster, target, pos, ar);
		target.playAnimation(BasicSparkAnimation.ID,"PARTICLE#spells/swirl");
		target.playSound("effects/Curse");
	}
	
}