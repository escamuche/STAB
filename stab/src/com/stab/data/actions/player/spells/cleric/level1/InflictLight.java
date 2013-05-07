package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.magic.FortitudeAttack;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.data.info.monster.monstertraits.UndeadTraits;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.Heal;

public class InflictLight extends SpellOnTarget{
	
	public static final String ID="INFLICTLIGHT";
	
	
	

	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int dañobase=Roll.d8()+1;
		
		MagicAttack ataque = new MagicAttack(caster);
		FortitudeAttack save = new FortitudeAttack(target);
		target.apply(ataque);
		target.apply(save);
		
		caster.playAnimationOn(ShootProyectileAnimation.ID, target.getToken(), "PARTICLE#magicmissile");
		
		if(target.hasTrait(UndeadTraits.ID) == false) {
			if(ataque.hits()) {
					if(save.hits()){
						Damage d= new Damage(dañobase, Damage.UNHOLY_DAMAGE,caster);
						target.apply(d);
						this.setEffectType(DAMAGE);
						return true;
						}
						else {
							Damage d= new Damage(dañobase/2, Damage.UNHOLY_DAMAGE,caster);
							target.apply(d);
							return false;
							}	
					}
						
				else {
					Heal d= new Heal(dañobase,caster);
					target.apply(d);
					this.setEffectType(HEAL);
					return true;
				}
		}
		return false;

	}
	
	public InflictLight() {
     
	 setLevel(1);
	 setCasterClass(StabConstants.CLERICCASTER);
	 setRange(TOUCH);
     
     setResource("actions/inflictlightwounds");
     setName("Inflict Light Wounds");
     
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
}