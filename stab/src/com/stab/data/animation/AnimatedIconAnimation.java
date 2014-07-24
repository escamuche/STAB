package com.stab.data.animation;

import com.stab.client.slick.base.updaters.SyncState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.states.ValueState;

public class AnimatedIconAnimation extends Animation {

	public static final String ID=VisualEffect.ANIMATED_ICON_ANIMATION;
	
	public AnimatedIconAnimation() {
		
	}
	
	@Override
	public void start() {
		super.start();
		int timed= getIntParam(0);
		int i=getIntParam(1);
		int f=getIntParam(2);
		int t=getIntParam(3);
		boolean loop=getBooleanParam(4);
		boolean bounce=getBooleanParam(5);
		
		StateSprite s=AnimUtils.getSprite(getSource());
		if (!s.isVisible()){
			setTime(0);
			return;
		}
		
		setTime(timed);
		

		
		
		ValueState st= new ValueState();
		
		if (!bounce){
			if (loop)
				st.setFrameLoop(0,i,t,f);
			else
				st.setFrame(0,i,t,f);
		}else{
			if (loop)
				st.setFrameLoop(0,i,t,f,t*2,i);
			else
				st.setFrame(0,i,t,f,t*2,i);
		}
		
		if (timed>0)
		 st.setTimed(timed, s.getCurrentStateId());
		//.setTimed(timed, SyncState.ID);
		
		
		s.setState(st);
		
		
		
	}
}
