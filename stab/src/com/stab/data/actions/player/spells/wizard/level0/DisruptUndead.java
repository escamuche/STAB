package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.data.info.monster.monstertraits.UndeadTraits;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class DisruptUndead extends SpellOnTarget{
	
	public static final String ID="DISRUPTUNDEAD";
	
	
	

	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int cl = getCasterLevel(caster);
		int dañobase=Roll.d6();
		
		
		MagicAttack ataque = new MagicAttack(caster);
		target.apply(ataque);
	
		caster.playAnimationOn(ShootProyectileAnimation.ID, target.getToken(), "PARTICLE#magicmissile");
		
		if(target.getTrait(UndeadTraits.ID) != null){
			
			if(ataque.hits()) {
					Damage d= new Damage(dañobase, Damage.HOLY_DAMAGE,caster);
					target.apply(d);
					return true;
					}
				}
		return false;
	}
	
	public DisruptUndead() {
     
	 setLevel(0);
	 setCasterClass(StabConstants.WIZARDCASTER);
     
     setResource("actions/disruptundead");
     setName("DisruptUndead");
     this.setEffectType(DAMAGE);
 	 setRange(CLOSE);
	
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
}
