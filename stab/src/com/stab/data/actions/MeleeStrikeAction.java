package com.stab.data.actions;

import com.stab.data.StabConstants;
import com.stab.data.animation.SwingAnimation;
import com.stab.data.info.applicable.Attack;
import com.stab.data.info.applicable.AttackData;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;

public class MeleeStrikeAction extends TargetAction{
	
	public static final String ID="MELEE_STRIKE_ACTION";

	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo atacante = (BaseInfo)yo;
		BaseInfo atacado = (BaseInfo)target;

		AttackData ad=new AttackData(atacante,atacado);
		atacante.apply(ad); //Esto calcula todos los bonos, daño etc
		
		Attack ataque = ad.getAttack();  //Esto nos da el ataque, ya preparado
		atacado.apply(ataque);
		
		//Aqui viene la animacion ((Sale del AD, pero por ahora esta fija) (y falta comprobar si hit, parry, etc)
		yo.playAnimationOn(SwingAnimation.ID, target.getToken(), ad.getAnimationIcon());
		sleep(500);
		
		if (ataque.hits()) {
			for (Applicable d:ad.getDamage(ataque.isCritical())){
				atacado.apply(d);
				//System.out.println(d.getFinalAmount()+" de daño (tipo "+d.getType()+")");
			}
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
	
	
	public MeleeStrikeAction() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_steelmelee");
     setName("Attack");
     this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return i.getAttributeValue(StabConstants.DAMAGE);  //REvisar
	}
	
}