package com.stab.pf.actions.player.spells.lvl0;

import java.awt.Point;

import com.stab.data.animation.BasicSparkAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTarget;
import com.stab.pf.info.debuff.condition.DazedCondition;

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
		setDescriptors(EffectDescriptor.ENCHANTMENT,EffectDescriptor.MIND_AFFECTING,EffectDescriptor.COMPULSION);
		this.setDescription("This spell clouds the mind of a humanoid creature with 4 or fewer Hit Dice so that it takes no actions. Humanoids of 5 or more HD are not affected. A dazed subject is not stunned, so attackers get no special advantage against it. After a creature has been dazed by this spell, it is immune to the effects of this spell for 1 minute.");
		this.setSave(StabConstants.WILLSAVE);
	}

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	//TODO: check de numero de HD del target
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
	public void playExecuteActionAnimation(Info caster, Info target,
			Point pos,ActionRequest ar) {
		super.playExecuteActionAnimation(caster, target, pos, ar);
		target.playAnimation(BasicSparkAnimation.ID,"PARTICLE#spells/swirl");
		target.playSound("effects/Curse");
	}
	
}