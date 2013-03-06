package com.stab.data.animation;

import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.animation.state.ShakeState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.action.base.WalkToAction;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;

public class ShakeAnimation extends Animation{

	public static final String ID=VisualEffect.SHAKE_ANIMATION_ID;
	
	public ShakeAnimation() {
		setBlocking(true);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		Token_sprite s=AnimUtils.getSprite(getSource());
	
		ShakeState st=new ShakeState(getTime());
		s.setState(st);
	}
	
	
}
