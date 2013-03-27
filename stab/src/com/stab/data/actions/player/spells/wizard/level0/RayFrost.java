package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootBeamAnimation;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class RayFrost extends SpellOnTarget{
	
	public static final String ID="RAYFROST";

	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		
		BaseInfo atacado = (BaseInfo)target;
		BaseInfo caster = (BaseInfo)yo;
		int cl = caster.getValue(StabConstants.CASTERLEVEL);
		int dañobase=Roll.d3();
		
		setRangeClose(cl);
		MagicAttack ataque = new MagicAttack(caster);
		atacado.apply(ataque);
		
		sleep(caster.playAnimationOn(ShootBeamAnimation.ID, atacado.getToken(), "PARTICLE#rayOfFrost"));
		
		if(ataque.hits()) {
			Damage d= new Damage(dañobase, Damage.COLD_DAMAGE,yo);
			atacado.apply(d);
			System.out.println(d.getFinalAmount()+" de daño");
			return true;	
		}
		return false;
	}
	public RayFrost() {
		
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/niaccoldray");
		setName("RayFrost");
		this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 1;
	}
	

}