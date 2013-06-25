package com.stab.data.animation;

import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.common.value.InterpolatorValueProvider;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.common.states.ValueState2;

public class DecayAnimation  extends Animation{

	public static final String ID=VisualEffect.DECAY_ANIMATION;
	
	public DecayAnimation() {
		setBlocking(true);
		setTime(1500);
	}
	
	@Override
	public void start() {
		super.start();
	
		
		
		Token_sprite s=AnimUtils.getSprite(getSource());
		if (s==null)
			return;
		ValueState2 st=new ValueState2();
		st.setBrightness(new InterpolatorValueProvider(0,1.0f,1000,0.f));
		st.setAlpha(new InterpolatorValueProvider(1000,1.0f,1500,0.0f));
		s.setState(st);
		
		
		
	}
}

