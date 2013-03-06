package com.stab.data.actions.player;

import com.stab.data.StabConstants;
import com.stab.data.animation.SwingAnimation;
import com.stab.data.info.applicable.Attack;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class Kill extends TargetAction{
	
	public static final String ID="Kill";

	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo Atacante = (BaseInfo)yo;
		BaseInfo Atacado = (BaseInfo)target;
		int dañobase=getBaseDamage(Atacante);
		
		Attack ataque = new Attack(Atacante);
		Atacado.apply(ataque);
		
		yo.playAnimationOn(SwingAnimation.ID, target.getToken(), getSwingImage(Atacante));
		sleep(500);
		if (ataque.hits()) {
			if (ataque.isCritical())
				dañobase=dañobase*2;
			Damage d= new Damage(dañobase, Damage.SLASHING_DAMAGE,yo);
			Atacado.apply(d);
			System.out.println(d.getFinalAmount()+" de daño");
			sleep(500);
			return true;	
		}
		
		
		sleep(500);
		if (ataque.isBotch()) {
			
			System.out.println("Pero mira que eres torpe!");
		    return false;
		}
		
		return false;
		
	}
	
	protected String getSwingImage(BaseInfo atacante) {
		return "effects/sword";
	}
	
	protected int getBaseDamage(BaseInfo Atacante) {
		return Roll.d8()+Atacante.getAttributeValue(StabConstants.DAMAGE);
	}

	public Kill() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_steelmelee");
     setName("Attack");
     this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return i.getAttributeValue(StabConstants.DAMAGE);
	}
	

}
