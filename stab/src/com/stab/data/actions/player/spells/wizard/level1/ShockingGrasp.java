package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class ShockingGrasp extends SpellOnTarget{
	
	public static final String ID="SHOCKINGGRASP";
	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo atacado = (BaseInfo)target;
		BaseInfo caster = (BaseInfo)yo;
		int dañobase=Roll.d6();
		
	
		MagicAttack ataque = new MagicAttack(caster);
		atacado.apply(ataque);
		
		caster.playAnimationOn(ShootProyectileAnimation.ID, atacado.getToken(), "PARTICLE#magicmissile");
		
		if(ataque.hits()) {
		Damage d= new Damage(dañobase, Damage.ELECTRIC_DAMAGE,yo);
		atacado.apply(d);
		return true;
		}
		return false;
	}
	
	public ShockingGrasp() {
     
	 setLevel(1);
	 setCasterClass(StabConstants.WIZARDCASTER);
     setTargetClass(PhysicalToken.class);
     setResource("actions/shockinggrasp");
     setName("ShockingGrasp");
     this.setEffectType(DAMAGE);
 	setRange(TOUCH);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
}
