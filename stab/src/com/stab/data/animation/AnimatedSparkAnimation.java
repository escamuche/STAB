package com.stab.data.animation;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.states.ValueState;
import com.tien.princess.engine.sprite.common.updaters.conditions.OnRefDestroyed;
import com.tien.princess.engine.utils.PaintUtils;

public class AnimatedSparkAnimation extends Animation {
	public static final String ID=VisualEffect.ANIMATED_SPARK_ANIMATION;
	
	public AnimatedSparkAnimation() {
		
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		String img=getParam(0);
	
		int timed= getIntParam(1);
		int i=getIntParam(2);
		int f=getIntParam(3);
		int t=getIntParam(4);
		boolean loop=getBooleanParam(5);
		boolean bounce=getBooleanParam(6);
		
		
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
		
		StabSprite icon=new StabSprite();
	
		if (timed>0)
			st.setTimed(timed, StateSet.DESTROYED);
		else{
			st.addUpdater(new OnRefDestroyed());
			icon.setRef(AnimUtils.getSprite(getSource()));
		}
		
		Painter p=PaintUtils.getPainter(img);
	
		
		

	
		icon.setPos(getOriginPoint());
		icon.setSize(64,64);
		
		icon.setPainter(p);
		
		icon.setState(st);

		
		StateSprite s=AnimUtils.getSprite(getSource());
		((AbstractGameScreen)s.getScreen()).add(icon);
	}

}
