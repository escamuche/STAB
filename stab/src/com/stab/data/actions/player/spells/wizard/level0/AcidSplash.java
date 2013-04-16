package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class AcidSplash extends SpellOnTarget{
	
	public static final String ID="ACIDSPLASH";
	
	
	

	@Override
	public boolean affect(Info instigator,Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receptor;
		int cl =getCasterLevel(caster);
		int dañobase=Roll.d3();
		
		
		
		MagicAttack ataque = new MagicAttack(caster);
		target.apply(ataque);
		
		caster.playAnimationOn(ShootProyectileAnimation.ID, target.getToken(), "PARTICLE#magicmissile");
		
		if(ataque.hits()) {
		Damage d= new Damage(dañobase, Damage.ACID_DAMAGE,caster);
		target.apply(d);
		System.out.println(d.getFinalAmount()+" de daño");	
		return true;
		}
		return false;
	}
	
	public AcidSplash() {
     
	 setLevel(0);
	 setCasterClass(StabConstants.WIZARDCASTER);
    
     setResource("actions/acidspray");
     setName("AcidSplash");
     this.setEffectType(DAMAGE);
     setRange(CLOSE);
     setMedium(MISSILE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 1;
	}
}