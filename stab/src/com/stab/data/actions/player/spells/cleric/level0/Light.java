package com.stab.data.actions.player.spells.cleric.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.BasicSparkAnimation;
import com.stab.data.info.buff.spells.LightInUse;
import com.stab.data.info.buff.spells.Light_Buff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.request.basic.ActionRequest;

public class Light extends SpellOnTarget{
	
	public static final String ID="LIGHT_CLERIC";
	
	
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
		
		Light_Buff mylight = new Light_Buff();
		target.addTrait(mylight);
		light.setBuff(mylight);
		
			return super.fullEffect(caster, target, point);
	}
	
	public Light() {
		setLevel(0);
		setCasterClass(StabConstants.CLERICCASTER);
		setRange(1);
		setResource("actions/light");
		setName("Light");
		this.setEffectType(BUFF);
	}
	
	@Override
	public void playExecuteActionAnimation(Info caster, Info target,
			Point pos,ActionRequest ar) {
		super.playExecuteActionAnimation(caster, target, pos, ar);
		target.playAnimation(BasicSparkAnimation.ID,"PARTICLE#spells/flash");
		target.playSound("HolyCast");
	}
}
