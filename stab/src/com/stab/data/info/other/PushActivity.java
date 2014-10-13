package com.stab.data.info.other;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.info.debuff.FatigueDebuff;
import com.stab.data.info.debuff.condition.FatiguedCondition;
import com.stab.model.basic.Sprite;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.info.trait.base.VisualEffect;

public class PushActivity extends PathfinderActivity{

	Info target;
	
	public PushActivity(int dc,Info target) {
		super(StabConstants.STRENGHT_CHECK, dc);
		setContinuous(true);
		this.setName("Pushing");
		setActivityIcon("blank");
		this.target=target;
	}
	
	
	
	
	@Override
	public void processActivity() {
		if (getTarget().hasTrait(FatiguedCondition.class)){
			cancelActivity();
			return;
		}
			
		super.processActivity();
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
		Point p=target.getPos();
		es.playAnimationOn(VisualEffect.DIRECTED_ANIMATED_SPARK_ANIMATION,p,"animations/push&0",32,-1,0,3,1000,true,false);
	}
}
