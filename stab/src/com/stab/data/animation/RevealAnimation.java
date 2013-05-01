package com.stab.data.animation;

import com.stab.model.action.base.SearchAction;
import com.stab.model.animation.Animation;
import com.stab.model.basic.token.Token;

public class RevealAnimation extends Animation{

	public static final String ID=SearchAction.REVEAL_ANIMATION_ID;
	
	@Override
	public void start() {
		super.start();
		((Token)getSource()).playAnimation(BasicSparkAnimation.ID,"PARTICLE#reveal");
	}
	
}
