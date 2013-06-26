package com.stab.data.animation;

import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.tien.princess.engine.sprite.StateSprite;

public class DefendAnimation extends Animation {

	public static final String ID="DEFEND_ANIMATION";
	
	public DefendAnimation() {
		setBlocking(false);
	}
	
	@Override
	public void start() {
		super.start();
		
		StateSprite s=AnimUtils.getSprite(getSource());
		
	}
}
