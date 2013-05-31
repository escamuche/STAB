package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Color;
import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.monster.monstertraits.UndeadTraits;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.Damage;

public class DisruptUndead extends SpellOnTarget {
	
	public static final String ID="DISRUPTUNDEAD";
	int dañobase=Roll.d6();
	
	public DisruptUndead() {
     
	 setLevel(0);
	 setCasterClass(StabConstants.WIZARDCASTER);
     
     setResource("actions/disruptundead");
     setName("DisruptUndead");
     this.setEffectType(DAMAGE);
 	 setRange(CLOSE);
 	 setMedium(MISSILE);
 	 this.setDescription("You direct a ray of positive energy. You must make a ranged touch attack to hit, and if the ray hits an undead creature, it deals 1d6 points of damage to it.");
	}

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		
		if(target.hasTrait(UndeadTraits.ID)) {	
		
					Damage d= new Damage(dañobase, Damage.HOLY_DAMAGE,caster);
					target.apply(d);
					return super.fullEffect(caster, target, point);
					
				}
		 target.showFloatingText("INEFFECTIVE", Color.pink);
		return false;
		
	}
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
	
}
