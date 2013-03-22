package com.stab.data.info.debuff.condition;

import com.stab.data.actions.HealAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.base.Debuff;

public class BleedCondition extends Debuff {

	public static final String ID="BLEEDCONDITION_DEBUFF";
	int damage = 0;
	
	
	public BleedCondition(BaseInfo target,int amount) {
	
		this.setAnimIcon("actions/bleedcondition");				
		this.setSound("HolyCast");
		this.setResource("actions/bleedcondition");                  
		
		this.setName("Bleed");
		this.setPermanent();
		damage = amount;
		
	}
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
			super.applyTo(baseInfo);
			baseInfo.getActionSet().setAction(HealAction.ID,-1);
	}
	@Override
	public void turnStarts() {
		super.turnStarts();
		BaseInfo i = getTarget();
		i.receiveDamage(damage, Damage.BLEED_DAMAGE, false);
	}
}
