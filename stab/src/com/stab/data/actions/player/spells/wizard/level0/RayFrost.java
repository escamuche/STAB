package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.MagicAttack;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class RayFrost extends TargetAction{
	
	public static final String ID="RAYFROST";

	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacante = (BaseInfo)yo;
		BaseInfo Atacado = (BaseInfo)target;
		int dañobase=Roll.d3();
		
		MagicAttack ataque = new MagicAttack(Atacante);
		Atacado.apply(ataque);
		
		Atacante.playAnimationOn(ShootProyectileAnimation.ID, Atacado.getToken(), "PARTICLE#magicmissile");
		
		if(ataque.hits()) {
		Damage d= new Damage(dañobase, Damage.COLD_DAMAGE,yo);
		Atacado.apply(d);
		System.out.println(d.getFinalAmount()+" de daño");
		return true;	
		}
		return false;
	}
	public RayFrost() {
     setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_mage_arcanebarrage");
     setName("RayFrost");
     this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 1;
	}
	

}