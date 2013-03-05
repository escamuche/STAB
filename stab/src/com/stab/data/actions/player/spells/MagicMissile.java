package com.stab.data.actions.player.spells;

import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.ReflexAttack;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class MagicMissile extends TargetAction{
	
	public static final String ID="MagicMissile";

	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacante = (BaseInfo)yo;
		BaseInfo Atacado = (BaseInfo)target;
		int da�obase=Roll.d4()+1;
		
		ReflexAttack ataque = new ReflexAttack(Atacante);
		Atacado.apply(ataque);
		
		Atacante.playAnimationOn(ShootProyectileAnimation.ID, Atacado.getToken(), "PARTICLE#magicmissile");
		
		if (ataque.hits()) {
			Damage d= new Damage(da�obase, Damage.FIRE_DAMAGE,yo);
			Atacado.apply(d);
			System.out.println(d.getFinalAmount()+" de da�o");
			return true;	
		}
		
		else {
		
			Damage d = new Damage(da�obase/2, Damage.FIRE_DAMAGE,yo);
			Atacado.apply(d);
			System.out.println(d.getFinalAmount()+" de da�o");
			return false;	
		}
		
	}
	
	public MagicMissile() {
     setRange(10);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_mage_arcanebarrage");
     setName("MagicMissile");
     this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
	

}