package com.stab.pf.actions.player.spells.lvl0;

import java.awt.Point;

import com.stab.client.animation.BasicSparkAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTarget;
import com.stab.pf.actions.player.spells.lvl0.effects.Virtue_Buff;


//WIP... aun pendiente de cambiar por otra cosa
//(el comportamiento de los puntos de vida temporales necesita ser revisado)

public class Virtue extends SpellOnTarget{
	
	public static final String ID="VIRTUE";

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		Virtue_Buff buff = new Virtue_Buff(getSpell(),caster);
		
		target.addTrait(buff);
		return super.fullEffect(caster, target, point);
	}
	
	public Virtue() {
		
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(CLOSE);
		setDescriptors(EffectDescriptor.TRANSMUTATION);
		setResource("actions/ability_druid_naturalperfection");
		setName("Virtue");
		this.setEffectType(BUFF);
		this.setDescription("With a touch, you infuse a creature with a tiny surge of life, granting the subject 1 temporary hit point.");
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 3;
	}
	
	@Override
	protected void playFullEffectAnimation(BaseInfo caster, BaseInfo target,
			Point point, ActionRequest ar) {
		super.playFullEffectAnimation(caster, target, point, ar);
		target.playAnimation(BasicSparkAnimation.ID, "PARTICLE#effects/healing");
	}	
	
}