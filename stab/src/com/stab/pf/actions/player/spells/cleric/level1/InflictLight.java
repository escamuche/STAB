package com.stab.pf.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.Heal;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellOnTarget;
import com.stab.pf.info.monster.monstertraits.UndeadTraits;

public class InflictLight extends SpellOnTarget{
	
	public static final String ID="INFLICTLIGHT";
	
	
	

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	int dañobase=Roll.d8()+1;
	
	caster.playAnimationOn(ShootProyectileAnimation.ID, target.getToken(), "PARTICLE#magicmissile");
	
	if(target.hasTrait(UndeadTraits.ID) == false) {
					Damage d= new Damage(dañobase, Damage.UNHOLY_DAMAGE,caster);
					target.apply(d);
					this.setEffectType(DAMAGE);
					return super.fullEffect(caster, target, point);
					}
					
			else {
				Heal d= new Heal(dañobase,caster);
				target.apply(d);
				this.setEffectType(HEAL);
				return super.fullEffect(caster, target, point);
			}
}

@Override
protected boolean partialEffect(BaseInfo caster, BaseInfo target, Point point) {
	int dañobase=Roll.d8()+1;
	
	caster.playAnimationOn(ShootProyectileAnimation.ID, target.getToken(), "PARTICLE#magicmissile");
	
	if(target.hasTrait(UndeadTraits.ID) == false) {
					Damage d= new Damage(dañobase/2, Damage.UNHOLY_DAMAGE,caster);
					target.apply(d);
				
					return super.partialEffect(caster, target, point);
					}
					
			else {
				Heal d= new Heal(dañobase,caster);
				target.apply(d);
		
				return super.partialEffect(caster, target, point);
			}
	
}
	
	public InflictLight() {
     
	 setLevel(1);
	 setCasterClass(StabConstants.CLERICCASTER);
	 setRange(TOUCH);
	 this.setLevel(1);
     setResource("actions/inflictlightwounds");
     setName("Inflict Light Wounds");
     setDescription("When laying your hand upon a creature, you channel negative energy that deals 1d8 points of damage + 1 point per caster level (maximum +5). Since undead are powered by negative energy, this spell cures such a creature of a like amount of damage, rather than harming it.");
	setSave(StabConstants.FORTITUDESAVE);
	}

	
	@Override
	public int getEffectType(Info instigator, Info target) {
		if (target instanceof BaseInfo)
			if(((BaseInfo)target).hasTrait(UndeadTraits.class))
			return HEAL;
		return DAMAGE;
			
	}
	
	@Override
	public int getEffectSubType(Info instigator, Info target) {
		int i=getEffectType(instigator, target);
		if (i==HEAL)
			return 0;
		return Damage.UNHOLY_DAMAGE;
		//return super.getEffectSubType(instigator, target);
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 9;
	}
}