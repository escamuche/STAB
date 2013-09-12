package com.stab.data.animation;

import com.stab.common.value.InterpolatorValueProvider;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.states.ValueState2;

public class FlashAnimation  extends Animation{

	public static final String ID=VisualEffect.FLASH_ANIMATION;
	
	public FlashAnimation() {
		setBlocking(false);
		setTime(100);
	}
	
	@Override
	public void start() {
		super.start();
	
		
		
		StateSprite s=AnimUtils.getSprite(getSource());
		if (s==null)
			return;
		ValueState2 st=new ValueState2();
		st.setBrightness(new InterpolatorValueProvider(0,1.0f,50,3.0f,100,1.0f));
		st.setTimed(100, s.getCurrentStateId());
		
		s.setState(st);
	}
}

