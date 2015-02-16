package com.stab.data.animation;

import com.stab.data.animation.sprite.SpecialEffectsSpriteFactory;
import com.stab.model.animation.Animation;

public class FlySwarmAnimation extends Animation {

	public static final String ID="FLYSWARM_ANIMATION";
	
	
	public FlySwarmAnimation() {
		setTime(-1);
	}
	
	@Override
	public void start() {
		System.out.println("____");
		super.start();
		getSource().playAnimation(GenericSpriteOnAnimation.ID,SpecialEffectsSpriteFactory.SPELLCASTING);
	}
}
