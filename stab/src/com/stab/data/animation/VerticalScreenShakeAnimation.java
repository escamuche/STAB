package com.stab.data.animation;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.data.animation.sprite.ScreenShakeSprite;
import com.stab.model.animation.Animation;
import com.tien.princess.engine.sprite.StateSprite;

public class VerticalScreenShakeAnimation extends Animation{

	public static final String ID="VERTICAL_SCREENSHAKE_ANIMATION";
	
	public VerticalScreenShakeAnimation() {
		setBlocking(true);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		StateSprite s=AnimUtils.getSprite(getSource());
		((AbstractGameScreen)s.getScreen()).add(new ScreenShakeSprite(getTime(), 10, true,2.0f));
		
	}
}