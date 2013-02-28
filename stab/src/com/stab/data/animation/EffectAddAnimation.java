package com.stab.data.animation;

import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.animation.state.TestAnimState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;

public class EffectAddAnimation  extends Animation {

	public static final String ID=VisualEffect.EFFECT_ADD_ANIMATION;
	
	public EffectAddAnimation() {
		setBlocking(true);
		setTime(700);
	}
	
	@Override
	public void start() {
		super.start();
		
		Token_sprite s=AnimUtils.getSprite(getSource());
		s.setState(new TestAnimState(this.getTime()));
	}
}
