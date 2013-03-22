package com.stab.data.info.debuff.condition;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.base.Debuff;
import com.stab.util.Roll;

public class BleedCondition extends Debuff {

	public static final String ID="BLEEDCONDITION_DEBUFF";
	
	public BleedCondition(BaseInfo target,int amount) {
	
		
		//this.setAnimIcon("actions/bane");				
		//this.setSound("HolyCast");
		//this.setResource("actions/bane");                  
		//this.setTime(10);
		//target.playAnimationOn(ShootProyectileAnimation.ID, atacado.getToken(), "PARTICLE#magicmissile");
		
		
		this.setName("Bleed");
		this.setPermanent();
		
		int healroll = Roll.d20() + target.getValue(StabConstants.HEALSKILL);
		if(healroll>14) 
			target.removeTrait(this.getId());
			else{
				Damage d = new Damage(amount,Damage.BLEED_DAMAGE,target);
				target.apply(d);
				
				}
	}
}
