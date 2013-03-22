package com.stab.data.info.debuff.condition;

import com.stab.data.StabConstants;
import com.stab.data.actions.HealAction;
import com.stab.data.actions.player.DefendAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.Trait;
import com.stab.model.info.trait.base.Debuff;
import com.stab.util.Roll;

public class BleedCondition extends Debuff {

	public static final String ID="BLEEDCONDITION_DEBUFF";
	int damage = 0;
	
	
	public BleedCondition(BaseInfo target,int amount) {
	
		//this.setAnimIcon("actions/bane");				
		//this.setSound("HolyCast");
		//this.setResource("actions/bane");                  
		
		this.setName("Bleed");
		this.setPermanent();
		damage = amount;
		
		int healroll = Roll.d20() + target.getValue(StabConstants.HEALSKILL);
		if(healroll>14) 
			target.removeTrait(this.getId());
	}
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
			super.applyTo(baseInfo);
			baseInfo.getActionSet().setAction(HealAction.ID,9);
	}
	@Override
	public void turnStarts() {
		super.turnStarts();
		BaseInfo i = getTarget();
		i.receiveDamage(damage, Damage.BLEED_DAMAGE, false);
	}
	
	@Override
	public boolean removeTrait(Trait trait) {
		
		BaseInfo self=getTarget();
		self.getActionSet().setAction(DefendAction.ID,9);
		return super.removeTrait(trait);
		
	}
}
