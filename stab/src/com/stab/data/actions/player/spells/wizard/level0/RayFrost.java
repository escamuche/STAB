package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootBeamAnimation;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class RayFrost extends SpellOnTarget{
	
	public static final String ID="RAYFROST";

	
	
	

	@Override
	public boolean affect(Info instigator, Info receptor) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int cl = getCasterLevel(caster);
		int da�obase=Roll.d3();
		
	
		MagicAttack ataque = new MagicAttack(caster);
		target.apply(ataque);
		
		sleep(caster.playAnimationOn(ShootBeamAnimation.ID, target.getToken(), "PARTICLE#rayOfFrost"));
		
		if(ataque.hits()) {
			Damage d= new Damage(da�obase, Damage.COLD_DAMAGE,caster);
			target.apply(d);
			System.out.println(d.getFinalAmount()+" de da�o");
			return true;	
		}
		return false;
	}
	public RayFrost() {
		
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/niaccoldray");
		setName("RayFrost");
		this.setEffectType(DAMAGE);
		setRange(CLOSE);
		setMedium(RAY);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 1;
	}
	

}