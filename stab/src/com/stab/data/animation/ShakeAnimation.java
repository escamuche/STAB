package com.stab.data.animation;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.data.animation.state.ShakeState;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;

public class ShakeAnimation extends Animation{

	public static final String ID=VisualEffect.SHAKE_ANIMATION;
	
	public ShakeAnimation() {
		setBlocking(true);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		StateSprite s=AnimUtils.getSprite(getSource());
	
		ShakeState st=new ShakeState(getTime());
		s.setState(st);
	}
	
	
}
