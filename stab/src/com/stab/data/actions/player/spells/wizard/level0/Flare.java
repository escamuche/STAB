package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.BasicSparkAnimation;
import com.stab.data.info.debuff.Flare_Debuff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class Flare extends SpellOnTarget{
	
	public static final String ID="FLARE";

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	Flare_Debuff buff = new Flare_Debuff();
	buff.setTime(10);
	target.addTrait(buff);
	return super.fullEffect(caster, target, point);
}
	
	public Flare() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		
		setResource("actions/flare");
		setName("Flare");
		this.setEffectType(BUFF);
		setRange(CLOSE);
		this.setDescription("This cantrip creates a burst of light. If you cause the light to burst in front of a single creature, that creature is dazzled for 1 minute unless it makes a successful Fortitude save. Sightless creatures, as well as creatures already dazzled, are not affected by flare.");
		this.setSave(StabConstants.FORTITUDESAVE);
	}
	
	@Override
	protected void playExecuteActionAnimation(Info caster, Info target,
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