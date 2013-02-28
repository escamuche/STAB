package com.stab.data.animation;

import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.animation.state.TestAnimState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;

public class TestAnimation  extends Animation {

	public static final String ID="TEST_ANIMATION";
	
	public TestAnimation() {
		setBlocking(true);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		
		Token_sprite s=AnimUtils.getSprite(getSource());
		s.setState(new TestAnimState(this.getTime()));
	}
}
