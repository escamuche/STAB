package com.stab.data.info.other;

import com.stab.data.StabConstants;
import com.stab.data.info.debuff.FatigueDebuff;
import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.basic.Sprite;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.info.trait.base.VisualEffect;

public class PushActivity extends PathfinderActivity{

	public PushActivity(int dc) {
		super(StabConstants.STRENGHT_CHECK, dc);
		setContinuous(true);
		this.setName("Pushing");
		setActivityIcon("animations/push&0");
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
		FatigueDebuff debuff = new FatigueDebuff(); 
		debuff.setTime(1);
		this.getTarget().addTrait(debuff);
	}
	
	
	@Override
	protected void configureEffectSprite(Sprite es) {
		//super.configureEffectSprite(es);
		es.playAnimation(VisualEffect.ANIMATED_ICON_ANIMATION,0,0,3,1000,true,false);
	}
}
