package com.stab.data.animation;

import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;

public class SuccessAnimation extends Animation {
	
	public static final String ID=VisualEffect.SUCCESS_ANIMATION;

	public SuccessAnimation() {
		setTime(1000);
	}
	
	@Override
	public void start() {
		getSource().playAnimation(VisualEffect.ANIMATED_SPARK_ANIMATION, "animations/success",1000,0,0,8,1000,false,false);
	}
	
}
