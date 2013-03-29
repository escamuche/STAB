package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class AcidSplash extends SpellOnTarget{
	
	public static final String ID="ACIDSPLASH";
	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo caster = (BaseInfo)yo;
		BaseInfo t = (BaseInfo)target;
		int cl =getCasterLevel(caster);
		int dañobase=Roll.d3();
		
		
		
		MagicAttack ataque = new MagicAttack(caster);
		t.apply(ataque);
		
		caster.playAnimationOn(ShootProyectileAnimation.ID, t.getToken(), "PARTICLE#magicmissile");
		
		if(ataque.hits()) {
		Damage d= new Damage(dañobase, Damage.ACID_DAMAGE,yo);
		t.apply(d);
		System.out.println(d.getFinalAmount()+" de daño");	
		return true;
		}
		return false;
	}
	
	public AcidSplash() {
     
	 setLevel(0);
	 setCasterClass(StabConstants.WIZARDCASTER);
     setTargetClass(PhysicalToken.class);
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