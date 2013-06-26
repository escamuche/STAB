package com.stab.data.animation;

import com.stab.client.slick.GameScreen;
import com.stab.data.animation.sprite.ScreenShakeSprite;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.tien.princess.engine.sprite.StateSprite;

public class HorizontalScreenShakeAnimation extends Animation{

	public static final String ID="HORIZONTAL_SCREENSHAKE_ANIMATION";
	
	public HorizontalScreenShakeAnimation() {
		setBlocking(true);
		setTime(620);
	}
	
	@Override
	public void start() {
		super.start();
		StateSprite s=AnimUtils.getSprite(getSource());
		((GameScreen)s.getScreen()).add(new ScreenShakeSprite(getTime(), 12, false,2.0f));
		
	}
}
