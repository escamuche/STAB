package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootBeamAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.Damage;

public class RayFrost extends SpellOnTarget{
	
	public static final String ID="RAYFROST";

	
	
	
/*
@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	int dañobase=Roll.d3();
	
	sleep(caster.playAnimationOn(ShootBeamAnimation.ID, target.getToken(), "PARTICLE#rayOfFrost"));
	
		Damage d= new Damage(dañobase, Damage.COLD_DAMAGE,caster);
		target.apply(d);
	return super.fullEffect(caster, target, point);
}
/**/

	public RayFrost() {
		
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setResource("actions/niaccoldray");
		setName("RayFrost");
		this.setEffectType(DAMAGE);
		setRange(CLOSE);
		setMedium(RAY);
		setWeapon(RayFrost.ID);
		this.setDescription("A ray of freezing air and ice projects from your pointing finger. You must succeed on a ranged touch attack with the ray to deal damage to a target. The ray deals 1d3 points of cold damage.");
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 1;
	}
	

}