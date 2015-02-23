package com.stab.pf.actions.player.spells.lvl0;

import java.awt.Color;
import java.awt.Point;

import com.stab.data.animation.BasicSparkAnimation;
import com.stab.model.ai.senses.SightSense;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTarget;
import com.stab.pf.actions.player.spells.lvl0.effects.Flare_Debuff;

public class Flare extends SpellOnTarget{
	
	public static final String ID="FLARE";

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	//Chechk sight sense en target
	if (target instanceof Creature)
		if (((Creature)target).getSense(SightSense.class)==null){
			target.showFloatingText("INEFFECTIVE", Color.pink);
			return false;
		}
	Flare_Debuff buff = new Flare_Debuff();
	buff.setTime(10);
	target.addTrait(buff);
	return super.fullEffect(caster, target, point);
}
	
	public Flare() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setDescriptors(EffectDescriptor.EVOCATION,EffectDescriptor.LIGHT);
		setResource("actions/flare");
		setName("Flare");
		this.setEffectType(BUFF);
		setRange(CLOSE);
		this.setDescription("This cantrip creates a burst of light. If you cause the light to burst in front of a single creature, that creature is dazzled for 1 minute unless it makes a successful Fortitude save. Sightless creatures, as well as creatures already dazzled, are not affected by flare.");
		this.setSave(StabConstants.FORTITUDESAVE);
	}
	
	@Override
	public void playExecuteActionAnimation(Info caster, Info target,
			Point pos,ActionRequest ar) {
		super.playExecuteActionAnimation(caster, target, pos, ar);
		target.playAnimation(BasicSparkAnimation.ID,"PARTICLE#spells/flash");
		target.playSound("effects/Curse");
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 2;
	}
	
}