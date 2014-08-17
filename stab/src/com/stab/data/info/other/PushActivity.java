package com.stab.data.info.other;

import com.stab.data.StabConstants;
import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.SkillRoll;

public class PushActivity extends PathfinderActivity{

	public PushActivity(int dc) {
		super(StabConstants.STRENGHT_CHECK, dc);
		setContinuous(true);
		this.setName("Pushing");
	}
	
	
	@Override
	public void advanceActivity() {
		if (getTarget().hasTrait(FatiguedCondition.class)){
			cancelActivity();
			return;
		}
			
		super.advanceActivity();
	}
	
	
	@Override
	protected void infoSupports(Info instigator) {
		if (instigator instanceof BaseInfo)
			if (((BaseInfo)instigator).hasTrait(FatiguedCondition.class)){
				return;
			}
		super.infoSupports(instigator);
	}
	
	@Override
	protected void fails(SkillRoll sk) {
		super.fails(sk);
		FatiguedCondition debuff = new FatiguedCondition(); 
		debuff.setTime(1);
		this.getTarget().addTrait(debuff);
	}
	
}
