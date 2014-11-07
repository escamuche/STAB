package com.stab.data.actions.player.spells.lvl0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.actions.player.spells.SpellProperties;
import com.stab.data.actions.player.spells.lvl0.effects.LightInUse;
import com.stab.data.actions.player.spells.lvl0.effects.Light_Buff;
import com.stab.data.animation.BasicSparkAnimation;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class Light extends SpellOnTarget{
	
	public static final String ID="LIGHT";

	//TODO:  cast en area como algo estatico? no, eso cae mas en luces danzantes que en light. Light requiere un target
	
	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		
		if(caster.hasTrait(LightInUse.ID)){
		
		}
		else{
		caster.addTrait(new LightInUse());
		}
		
		LightInUse light = (LightInUse) caster.getTrait(LightInUse.ID);
		if(light.getBuff()!=null)
				light.getBuff().end();
		
		Light_Buff mylight = new Light_Buff(this.getSpell(), caster);
		target.addTrait(mylight);
		light.setBuff(mylight);
		
		return super.fullEffect(caster, target, point);
	}
	
	public Light() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setRange(TOUCH);
		setResource("actions/light");
		setName("Light");
		this.setEffectType(BUFF);
		setDescriptors(EffectDescriptor.EVOCATION,EffectDescriptor.LIGHT);
		setDescription("This spell causes a touched object to glow like a torch, shedding normal light in a 20-foot radius, and increasing the light level for an additional 20 feet by one step, up to normal light (darkness becomes dim light, and dim light becomes normal light). In an area of normal or bright light, this spell has no effect. The effect is immobile, but it can be cast on a movable object.");
		setDismissable(true);
		setDuration(SpellProperties.MEDIUM);
		
		
	}
	
	@Override
	public void playExecuteActionAnimation(Info caster, Info target,
			Point pos,ActionRequest ar) {
		super.playExecuteActionAnimation(caster, target, pos, ar);
		target.playAnimation(BasicSparkAnimation.ID,"PARTICLE#spells/flash");
		target.playSound("HolyCast");
	}
}
