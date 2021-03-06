package com.stab.pf.info.debuff.condition;

import org.newdawn.slick.Color;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.Damage;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.general.HealAction;

public class DyingCondition extends UnableToActCondition {

	public static final String ID="DYINGCONDITION_DEBUFF";
	
	public DyingCondition() {
	
		this.setAnimIcon("actions/bleedcondition");				
		this.setSound("HolyCast");
		this.setResource("actions/bleedcondition");                  
		
		this.setName("Dying");
		this.setPermanent();
		addTrait(new CannotThreatCondition());
	
		 
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
		}else{
			i.showFloatingText("DYING ("+die+")", Color.red);
		}
	}
}