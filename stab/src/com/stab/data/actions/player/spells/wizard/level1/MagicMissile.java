package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.MagicMissileAnimation;
import com.stab.data.info.applicable.RolledDamage;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class MagicMissile extends SpellOnTarget{
	
	public static final String ID="MagicMissile";
	
	@Override
	public boolean affect(Info instigator, Info receptor) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int cl = getCasterLevel(caster);
		
		int number=cl+1/2;
		if (number>5) number=5;
		
		sleep(caster.playAnimationOn(MagicMissileAnimation.ID, target.getToken(), number));
		
		Damage d= new RolledDamage(number,4,number, Damage.FORCE_DAMAGE,caster);
		target.apply(d);
		
		return true;
		}
	
	public MagicMissile() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/magicmissile");
		setName("MagicMissile");
		this.setEffectType(DAMAGE);
		setRange(MEDIUM);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return (((i.getAttributeValue(StabConstants.CASTERLEVELWIZARD)+1)/2)*3);
	}
	

}