package com.stab.pf.actions.player.spells.lvl0;

import java.awt.Color;
import java.awt.Point;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTarget;
import com.stab.pf.info.monster.monstertraits.UndeadTraits;

public class DisruptUndead extends SpellOnTarget {
	
	public static final String ID="DISRUPTUNDEAD";
	
	public DisruptUndead() {
     
	 setLevel(0);
	 setCasterClass(StabConstants.WIZARDCASTER);
     
     setResource("actions/disruptundead");
     setName("DisruptUndead");
     this.setEffectType(DAMAGE);
 	 setRange(CLOSE);
 	 setMedium(MISSILE);
 	 this.setDescription("You direct a ray of positive energy. You must make a ranged touch attack to hit, and if the ray hits an undead creature, it deals 1d6 points of damage to it.");
 	 setWeapon(ID);
 	 setDescriptors(EffectDescriptor.NECROMANCY);
	}

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		
		if (target.hasTrait(UndeadTraits.ID)) {	
		
					Damage d= new RolledDamage(1,6,0, Damage.HOLY_DAMAGE,caster);
					getSpell().adjust(d);
					target.apply(d);
					return super.fullEffect(caster, target, point);
					
				}
		else
			target.showFloatingText("INEFFECTIVE", Color.pink);
		return false;
		
	}
	
	
	@Override
	public int getEffectSubType(Info instigator, Info target) {
		return Damage.HOLY_DAMAGE;
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		if (target instanceof BaseInfo)
		if (!((BaseInfo)target).hasTrait(UndeadTraits.ID))
			return 0;
		return 6;
	}
	
}
