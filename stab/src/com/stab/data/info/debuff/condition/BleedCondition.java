package com.stab.data.info.debuff.condition;

import com.stab.data.actions.general.HealAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.base.DebuffEffect;

public class BleedCondition extends DebuffEffect {

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
			
			//TODO: añadir con extra la contextualoption
			//baseInfo.getActionSet().setAction(HealAction.ID,-1);
	}
	@Override
	public void turnStarts() {
		super.turnStarts();
		BaseInfo i = getTarget();
		Damage d= new Damage(damage,Damage.BLEED_DAMAGE,i);
		i.apply(d);
	}
}
