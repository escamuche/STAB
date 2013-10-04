package com.stab.data.animation;

import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;

public class WaitAnimation  extends Animation{

	public static final String ID=VisualEffect.WAIT_ANIMATION;
	
	public WaitAnimation() {
		setBlocking(true);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		/*StateSprite s=AnimUtils.getSprite(getSource());**/
		int i=getIntParam(0);
		setTime(i);
	}
}
