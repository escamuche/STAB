package com.stab.data.animation;

import org.newdawn.slick.Color;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.states.ValueState2;
import com.tien.princess.engine.sprite.common.updaters.misc.ColorUpdater;
import com.tien.princess.engine.utils.ColorInterpolatorProvider;

public class MarkAnimation  extends Animation{

	public static final String ID=VisualEffect.MARK_ANIMATION;
	
	public MarkAnimation() {
		setTime(400);
	}
	
	@Override
	public void start() {
		super.start();
	
		
		
		StateSprite s=AnimUtils.getSprite(getSource());
		if (s==null)
			return;
		ValueState2 st=new ValueState2();
		st.setBrightness(true,0,1.0f,50,3.0f,100,1.0f);
		st.addUpdater( new ColorUpdater(new ColorInterpolatorProvider(Color.white, 50, Color.yellow)));
		st.setTimed(400, s.getCurrentStateId());
		
		s.setState(st);
	}
}


