package com.stab.data.animation;

import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;

public class FailureAnimation extends Animation {
	
	public static final String ID=VisualEffect.FAILURE_ANIMATION;

	public FailureAnimation() {
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		getSource().playAnimation(VisualEffect.ANIMATED_SPARK_ANIMATION, "animations/failure&0",1000,0,8,1000,false,false);
	}
	
}
