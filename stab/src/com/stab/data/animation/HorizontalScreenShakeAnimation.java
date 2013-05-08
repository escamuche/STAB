package com.stab.data.animation;

import com.stab.model.animation.Animation;

public class HorizontalScreenShakeAnimation extends Animation{

	public static final String ID="HORIZONTAL_SCREENSHAKE_ANIMATION";
	
	public HorizontalScreenShakeAnimation() {
		setBlocking(true);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		
		//((GameScreen)s.getScreen()).add(new ScreenShakeSprite(getTime(), 10, false));
		
	}
}
