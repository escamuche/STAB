package com.stab.data.animation;

import com.stab.model.action.base.SearchAction;
import com.stab.model.animation.Animation;

public class RevealAnimation extends Animation{

	public static final String ID=SearchAction.REVEAL_ANIMATION_ID;
	
	@Override
	public void start() {
		super.start();
		getSource().playAnimation(BasicSparkAnimation.ID,"PARTICLE#reveal");
	}
	
}
