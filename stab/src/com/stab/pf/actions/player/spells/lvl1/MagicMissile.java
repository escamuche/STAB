package com.stab.pf.actions.player.spells.lvl1;

import java.awt.Point;

import com.stab.annotations.Instanced;
import com.stab.data.animation.MagicMissileAnimation;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTarget;
import com.stab.pf.actions.player.spells.lvl1.effects.Shield_Buff;

@Instanced
public class MagicMissile extends SpellOnTarget{
	
	public static final String ID="MAGICMISSILE";
	
	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		int cl = getCasterLevel(caster);
		
		int number=cl+1/2;
		if (number>5) number=5;
	
		boolean blocked=false;
		
		if (target.hasTrait(Shield_Buff.class))
			blocked=true;
		
		sleep(caster.playAnimationOn(MagicMissileAnimation.ID, target.getToken(), number,blocked));
		
		Damage d= new RolledDamage(number,4,number, Damage.FORCE_DAMAGE,caster);
		if (!blocked)
			target.apply(d);
		
		return super.fullEffect(caster, target, point);
	}
	
	public MagicMissile() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		
		setResource("actions/magicmissile");
		setName("MagicMissile");
		this.setEffectType(DAMAGE);
		setRange(MEDIUM);
		this.setDescription("A missile of magical energy darts forth from your fingertip and strikes its target, dealing 1d4+1 points of force damage. The missile strikes unerringly, even if the target is in melee combat, so long as it has less than total cover or total concealment. Specific parts of a creature can't be singled out. Objects are not damaged by the spell. For every two caster levels beyond 1st, you gain an additional missile—two at 3rd level, three at 5th, four at 7th, and the maximum of five missiles at 9th level or higher.");
		setDescriptors(EffectDescriptor.EVOCATION,EffectDescriptor.FORCE);
	}

	
	@Override
	public int getEffectSubType(Info instigator, Info target) {
		return Damage.FORCE_DAMAGE;
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		int cl = getCasterLevel(i);
		
		int number=cl+1/2;
		if (number>5) number=5;
		return number*5;
	}
	
	

}