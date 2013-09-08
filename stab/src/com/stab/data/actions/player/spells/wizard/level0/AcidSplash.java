package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class AcidSplash extends SpellOnTarget{
	
	public static final String ID="ACIDSPLASH";
	
	
	
/*
@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	int dañobase=Roll.d3();
	
	caster.playAnimationOn(ShootProyectileAnimation.ID, target.getToken(), "PARTICLE#magicmissile");
	
	Damage d= new Damage(dañobase, Damage.ACID_DAMAGE,caster);
	target.apply(d);
	return super.fullEffect(caster, target, point);
}
/**/
	
	public AcidSplash() {
     
	 setLevel(0);
	 setCasterClass(StabConstants.WIZARDCASTER);
    
     setResource("actions/acidspray");
     setName("AcidSplash");
     this.setEffectType(DAMAGE);
     this.setEffectSubType(Damage.ACID_DAMAGE);
     setRange(CLOSE);
     setMedium(MISSILE);
     setWeapon(AcidSplash.ID);
     setAffectedBySR(false);
     this.setDescription("You fire a small orb of acid at the target. You must succeed on a ranged touch attack to hit your target. The orb deals 1d3 points of acid damage. This acid disappears after 1 round.");
   //  this.setSave(StabConstants.FORTITUDESAVE);
	}

	
	
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 3;
	}
}