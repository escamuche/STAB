package com.stab.data.info.other;

import com.stab.model.basic.Sprite;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.model.info.trait.base.activity.TinkerActivity;

public class PickLockActivity extends TinkerActivity{

	public PickLockActivity() {
	
		this.setName("LockPicking");
		setActivityIcon("animations/pickLock&0");
	}
	
	
	@Override
	public void advanceActivity() {
		super.advanceActivity();
	//	System.out.println("pick lock "+this.getProgress()+" of "+this.getMaxProgress()+" finished? "+this.isFinished()+" shouldEndTurn? "+this.shouldEndTurn());
	}
	
	@Override
	protected void configureEffectSprite(Sprite es) {
	    super.configureEffectSprite(es);
		es.playAnimation(VisualEffect.ANIMATED_ICON_ANIMATION,0,0,3,1000,true,false);
	}
}
