package com.stab.data.info.debuff.condition;

import com.stab.data.StabConstants;
import com.stab.data.actions.HealAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.base.Debuff;

public class DyingCondition extends Debuff {

	public static final String ID="DYINGCONDITION_DEBUFF";
	
	public DyingCondition() {
	
		this.setAnimIcon("actions/bleedcondition");				
		this.setSound("HolyCast");
		this.setResource("actions/bleedcondition");                  
		
		this.setName("Dying");
		this.setPermanent();
		
		 
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
		Damage d= new Damage(1,Damage.BLEED_DAMAGE,i);
		i.apply(d);
		int die = i.getHp();
		if(-die>=i.getValue(StabConstants.CONSTITUTION)){
			i.addTrait(new DeadCondition());
			i.removeTrait(DyingCondition.ID);
		}
	}
}