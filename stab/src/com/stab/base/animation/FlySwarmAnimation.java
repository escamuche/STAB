package com.stab.base.animation;

import com.stab.client.animation.GenericSpriteOnAnimation;
import com.stab.model.animation.Animation;
import com.stab.pf.animations.sprite.SpecialEffectsSpriteFactory;

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
