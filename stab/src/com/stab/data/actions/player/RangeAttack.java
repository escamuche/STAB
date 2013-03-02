package com.stab.data.actions.player;

import com.stab.data.StabConstants;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.Attack;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class RangeAttack extends TargetAction{
	
	public static final String ID="RangeAttack";

	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacante = (BaseInfo)yo;
		BaseInfo Atacado = (BaseInfo)target;
		int dañobase=Atacante.getValue(StabConstants.DAMAGE);
		
		Attack ataque = new Attack(Atacante);
		Atacado.apply(ataque);
		
		if (ataque.hits()) {
			
			Atacante.playAnimationOn(ShootProyectileAnimation.ID, Atacado.getToken(), "effects/arrow");
			
			Damage d= new Damage(dañobase, Damage.PIERCING_DAMAGE,yo);
			Atacado.apply(d);
			System.out.println(d.getFinalAmount()+" de daño");
			
			
			return true;	
		}
		
		if (ataque.isCritical()) {
			
			dañobase=dañobase*2;
			Damage d= new Damage(dañobase, Damage.PIERCING_DAMAGE,yo);
			Atacado.apply(d);
			System.out.println(d.getFinalAmount()+" de daño");
			return true;	
			
		}
		
		if (ataque.isBotch()) {
			
			System.out.println("Pero mira que eres torpe!");
		    return false;
		}
		
		return true;
		
	}
	
	public RangeAttack() {
     setRange(6);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_hunter_focusfire");
     setName("RangeAttack");
     this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return i.getAttributeValue(StabConstants.DAMAGE);
	}
	

}