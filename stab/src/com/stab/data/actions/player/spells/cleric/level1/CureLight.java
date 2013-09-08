package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.monster.monstertraits.UndeadTraits;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.Heal;
import com.stab.model.info.trait.base.VisualEffect;

public class CureLight extends SpellOnTarget{
	
	public static final String ID="CURELIGHT_CLERIC";


@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	int cl=getCasterLevel(caster);
	if(cl>5)
		cl=5;
	int dañobase=Roll.d8()+cl;
	
	if (target.hasTrait(UndeadTraits.ID) == false) {
		Heal heal = new Heal(dañobase, caster);
		target.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#effects/healing");
		sleep(500);
		target.apply(heal);
		this.setEffectType(HEAL);
		return super.fullEffect(caster, target, point);
		}
	
	else {
				Damage d= new Damage(dañobase, Damage.HOLY_DAMAGE,caster);
				target.apply(d);
				return super.fullEffect(caster, target, point);
			}

}

@Override
	protected boolean partialEffect(BaseInfo caster, BaseInfo target, Point point) {
	int cl=getCasterLevel(caster);
	if(cl>5)
		cl=5;
	int dañobase=Roll.d8()+cl;
	
	if (target.hasTrait(UndeadTraits.ID) == false) {
		Heal heal = new Heal(dañobase, caster);
		target.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#damage/holyBurn");
		sleep(500);
		target.apply(heal);
		this.setEffectType(HEAL);
		return super.partialEffect(caster, target, point);
		}
	
	else {
				Damage d= new Damage(dañobase/2, Damage.HOLY_DAMAGE,caster);
				target.apply(d);
				return super.partialEffect(caster, target, point);
			}
}
	
	public CureLight() {
   
     
     setResource("actions/curelightwounds");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("Cure Light");
  	 this.setRange(TOUCH);
  	 this.setDescription("When laying your hand upon a living creature, you channel positive energy that cures 1d8 points of damage + 1 point per caster level (maximum +5). Since undead are powered by negative energy, this spell deals damage to them instead of curing their wounds. An undead creature can apply spell resistance, and can attempt a Will save to take half damage.");
  	 this.setLevel(1);
  	 this.setSave(StabConstants.FORTITUDESAVE);
  	 
	}
	@Override
	public int getEffectType(Info instigator, Info target) {
		if (target instanceof BaseInfo)
			if(((BaseInfo)target).hasTrait(UndeadTraits.class))
			return DAMAGE;
		return HEAL;
			
	}
	
	@Override
	public int getEffectSubType(Info instigator, Info target) {
		int i=getEffectType(instigator, target);
		if (i==HEAL)
			return 0;
		return Damage.HOLY_DAMAGE;
		//return super.getEffectSubType(instigator, target);
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 9;
	}
	

}