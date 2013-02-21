package com.stab.data.animation;

import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;

public class DefendAnimation extends Animation {

	public static final String ID="DEFEND_ANIMATION";
	
	public DefendAnimation() {
		setBlocking(false);
	}
	
	@Override
	public void start() {
		super.start();
		
		Token_sprite s=AnimUtils.getSprite(getSource());
		
	}
}
