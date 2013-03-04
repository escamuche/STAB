package com.stab.data.actions.player;

import com.stab.data.StabConstants;
import com.stab.data.animation.MissProyectileAnimation;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.RangedAttack;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class RangedKill extends TargetAction{
	
	public static final String ID="RangedKill";

	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacante = (BaseInfo)yo;
		BaseInfo Atacado = (BaseInfo)target;
		int da�obase=Atacante.getValue(StabConstants.DAMAGERANGED);
		
		RangedAttack ataque = new RangedAttack(Atacante);
		Atacado.apply(ataque);
		
		if (ataque.hits()) {
			
			Atacante.playAnimationOn(ShootProyectileAnimation.ID, Atacado.getToken(), "effects/arrow");
			Damage d= new Damage(da�obase, Damage.PIERCING_DAMAGE,yo);
			Atacado.apply(d);
			System.out.println(d.getFinalAmount()+" de da�o");
			return true;	
		}
		
		if (ataque.isCritical()) {
			
			Atacante.playAnimationOn(ShootProyectileAnimation.ID, Atacado.getToken(), "effects/arrow");
			da�obase=da�obase*2;
			Damage d= new Damage(da�obase, Damage.PIERCING_DAMAGE,yo);
			Atacado.apply(d);
			System.out.println(d.getFinalAmount()+" de da�o");
			return true;	
			
		}
		
		if (ataque.isBotch()) {
			
			System.out.println("Pero mira que eres torpe!");
		    return false;
		}
		
		Atacante.playAnimationOn(MissProyectileAnimation.ID, Atacado.getToken(), "effects/arrow");
		return false;
		
	}
	
	public RangedKill() {
     setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_hunter_focusfire");
     setName("RangedAttack");
     this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return i.getAttributeValue(StabConstants.DAMAGERANGED);
	}
	

}