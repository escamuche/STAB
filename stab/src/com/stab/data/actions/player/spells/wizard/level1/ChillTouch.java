package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.data.info.debuff.ChillTouch_Debuff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.Damage;

public class ChillTouch extends SpellOnTarget{
	
	public static final String ID="CHILLTOUCH";
	
	
	
@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	int dañobase=Roll.d6();
	
	caster.playAnimationOn(ShootProyectileAnimation.ID, target.getToken(), "PARTICLE#magicmissile");
	
	Damage d= new Damage(dañobase, Damage.UNHOLY_DAMAGE,caster);
	target.apply(d);
	
	SavingThrowEffect save= new SavingThrowEffect(caster, StabConstants.FORTITUDESAVE, target);
	save.check();
	if(save.failed()){
		ChillTouch_Debuff chilltouch = new ChillTouch_Debuff();
		target.addTrait(chilltouch);
	}
	return super.fullEffect(caster, target, point);
}

@Override
protected boolean partialEffect(BaseInfo caster, BaseInfo target, Point point) {	
	int dañobase=Roll.d6();
	
	caster.playAnimationOn(ShootProyectileAnimation.ID, target.getToken(), "PARTICLE#magicmissile");
	
	Damage d= new Damage(dañobase, Damage.UNHOLY_DAMAGE,caster);
	target.apply(d);
	return super.partialEffect(caster, target, point);
}


	
	// falta el tema de panicked a undeads...
	
	public ChillTouch() {
     
	 setLevel(1);
	 setCasterClass(StabConstants.WIZARDCASTER);
     
     setResource("actions/chilltouch");
     setName("Chill Touch");
     this.setEffectType(DAMAGE);
     setRange(TOUCH);
 	 setWeaponChargeSpell(true);
     this.setDescription("A touch from your hand, which glows with blue energy, disrupts the life force of living creatures. Each touch channels negative energy that deals 1d6 points of damage. The touched creature also takes 1 point of Strength damage unless it makes a successful Fortitude saving throw. You can use this melee touch attack up to one time per level. An undead creature you touch takes no damage of either sort, but it must make a successful Will saving throw or flee as if panicked for 1d4 rounds + 1 round per caster level.");
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
}
