package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.Attack;
import com.stab.data.info.applicable.magic.FortitudeAttack;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class InflictLight extends SpellOnTarget{
	
	public static final String ID="INFLICTLIGHT";
	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacante = (BaseInfo)yo;
		BaseInfo Atacado = (BaseInfo)target;
		int dañobase=Roll.d8()+1;
		
		Attack ataque = new Attack(Atacante);
		FortitudeAttack save = new FortitudeAttack(Atacado);
		Atacado.apply(ataque);
		
		Atacante.playAnimationOn(ShootProyectileAnimation.ID, Atacado.getToken(), "PARTICLE#magicmissile");
		
		if(ataque.hits()) {
			if(save.hits()){
		Damage d= new Damage(dañobase, Damage.UNHOLY_DAMAGE,yo);
		Atacado.apply(d);
		System.out.println(d.getFinalAmount()+" de daño");	
		return true;
		}
			else {
				Damage d= new Damage(dañobase/2, Damage.ACID_DAMAGE,yo);
				Atacado.apply(d);
				System.out.println(d.getFinalAmount()+" de daño");	
				return false;
			}
		}
		return false;
	}
	
	public InflictLight() {
     
	 setLevel(1);
	 setCasterClass(StabConstants.CLERICCASTER);
	 setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/inflictlightwounds");
     setName("Inflict Light Wounds");
     this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
}