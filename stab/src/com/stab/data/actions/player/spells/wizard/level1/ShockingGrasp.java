package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class ShockingGrasp extends SpellOnTarget{
	
	public static final String ID="SHOCKINGGRASP";
	
	
	

	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int dañobase=Roll.d6();
		
	
		MagicAttack ataque = new MagicAttack(caster);
		target.apply(ataque);
		
		caster.playAnimationOn(ShootProyectileAnimation.ID, target.getToken(), "PARTICLE#magicmissile");
		
		if(ataque.hits()) {
		Damage d= new Damage(dañobase, Damage.ELECTRIC_DAMAGE,caster);
		target.apply(d);
		return true;
		}
		return false;
	}
	
	public ShockingGrasp() {
     
	 setLevel(1);
	 setCasterClass(StabConstants.WIZARDCASTER);
     
     setResource("actions/shockinggrasp");
     setName("ShockingGrasp");
     this.setEffectType(DAMAGE);
 	 setRange(TOUCH);
 	 this.setDescription("Your successful melee touch attack deals 1d6 points of electricity damage per caster level (maximum 5d6). When delivering the jolt, you gain a +3 bonus on attack rolls if the opponent is wearing metal armor (or is carrying a metal weapon or is made of metal).");
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
}
