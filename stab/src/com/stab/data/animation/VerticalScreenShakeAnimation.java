package com.stab.data.animation;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.animation.sprite.ScreenShakeSprite;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;

public class VerticalScreenShakeAnimation extends Animation{

	public static final String ID="VERTICAL_SCREENSHAKE_ANIMATION";
	
	public VerticalScreenShakeAnimation() {
		setBlocking(true);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		Token_sprite s=AnimUtils.getSprite(getSource());
		((GameScreen)s.getScreen()).add(new ScreenShakeSprite(getTime(), 10, true,2.0f));
		
	}
}