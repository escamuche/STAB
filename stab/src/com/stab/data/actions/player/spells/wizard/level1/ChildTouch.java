package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.FortitudeAttack;
import com.stab.data.info.applicable.MagicAttack;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class ChildTouch extends SpellOnTarget{
	
	public static final String ID="CHILDTOUCH";
	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacante = (BaseInfo)yo;
		BaseInfo Atacado = (BaseInfo)target;
		int dañobase=Roll.d6();
		
		MagicAttack ataque = new MagicAttack(Atacante);
		Atacado.apply(ataque);
		
		Atacante.playAnimationOn(ShootProyectileAnimation.ID, Atacado.getToken(), "PARTICLE#magicmissile");
		
		Damage d= new Damage(dañobase, Damage.UNHOLY_DAMAGE,yo);
		Atacado.apply(d);
		System.out.println(d.getFinalAmount()+" de daño");
		
		if(ataque.hits()) {
			FortitudeAttack ataque2 = new FortitudeAttack(Atacante);
			Atacado.apply(ataque2);
			if(ataque.hits()){
				//falta un ChildTouch_Debuff que le quite 1 de fuerza
			}
		return true;
		}
		return false;
	}
	
	// falta el tema de panicked a undeads...
	// y la duracion 1 golpe/nivel (cargas)
	
	public ChildTouch() {
     
	 setLevel(1);
	 setCasterClass(StabConstants.WIZARDCASTER);
	 setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_mage_arcanebarrage");
     setName("ShockingGrasp");
     this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
}
