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
import com.stab.util.Roll;

public class RangedKill extends TargetAction{
	
	public static final String ID="RangedKill";

	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacante = (BaseInfo)yo;
		BaseInfo Atacado = (BaseInfo)target;
		int dañobase=getBaseDamage(Atacante);
		
		RangedAttack ataque = new RangedAttack(Atacante);
		Atacado.apply(ataque);
		
		
		if (ataque.hits()) {
			if (ataque.isCritical()) {
				dañobase=dañobase*2;
			}
			
			sleep(Atacante.playAnimationOn(ShootProyectileAnimation.ID, Atacado.getToken(), "effects/arrow"));
			Damage d= new Damage(dañobase, getTypeDamage(Atacante),yo);
			Atacado.apply(d);
			System.out.println(d.getFinalAmount()+" de daño");
			return true;	
		}
	
		
		if (ataque.isBotch()) {
			
			System.out.println("Pero mira que eres torpe!");
		    return false;
		}
		
		sleep(Atacante.playAnimationOn(MissProyectileAnimation.ID, Atacado.getToken(), "effects/arrow"));
		return false;
		
	}
	
	public RangedKill() {
     setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_hunter_focusfire");
     setName("RangedAttack");
     this.setEffectType(DAMAGE);
	}

	protected int getBaseDamage(BaseInfo Atacante) {
		return Roll.d8()+Atacante.getAttributeValue(StabConstants.DAMAGERANGED);
	}
	
	
	protected int getTypeDamage(BaseInfo Atacante) {
		return Damage.PIERCING_DAMAGE;
	}
	
	@Override
	public int getEffectValue(BaseInfo i) {
		return i.getAttributeValue(StabConstants.DAMAGERANGED);
	}
	

}