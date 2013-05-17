package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.MagicMissileAnimation;
import com.stab.data.info.applicable.RolledDamage;
import com.stab.data.info.buff.spells.Shield_Buff;
import com.stab.model.basic.Sprite;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class MagicMissile extends SpellOnTarget{
	
	public static final String ID="MagicMissile";
	
	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
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
		
		return true;
		}
	
	public MagicMissile() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		
		setResource("actions/magicmissile");
		setName("MagicMissile");
		this.setEffectType(DAMAGE);
		setRange(MEDIUM);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return (((i.getAttributeValue(StabConstants.WIZARDCASTER)+1)/2)*3);
	}
	
	

}