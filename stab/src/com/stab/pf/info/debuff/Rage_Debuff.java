package com.stab.pf.info.debuff;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.base.DebuffEffect;
import com.stab.pf.info.debuff.condition.FatiguedCondition;

public class Rage_Debuff extends DebuffEffect {

	public static final String ID="RAGE_DEBUFF";
	
	public Rage_Debuff() {
	
		
		this.setAnimIcon("actions/fatigued");				
		this.setSound("HolyCast");
		this.setResource("actions/fatigued");                  
		this.setName("Rage Debuff");
		this.setUnique(true);

		
		FatiguedCondition debuff = new FatiguedCondition(); 
		addTrait(debuff);	
	}
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
			super.applyTo(baseInfo);
			baseInfo.receiveDamage(2, Damage.GENERIC_DAMAGE, false,false,Applicable.OK); //igual que el heal se pone aqui para que solo se aplique cuando te ponen el debuff
	}
	
}