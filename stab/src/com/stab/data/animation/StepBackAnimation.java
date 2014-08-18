package com.stab.data.animation;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.data.animation.state.StepBackState;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.sprite.StateSprite;

public class StepBackAnimation extends OnTargetAnimation{

	public static final String ID="STEPBACK_ANIMATION";
	
	public StepBackAnimation() {
		setTime(700);
	}
	
	@Override
	public void start() {
		super.start();
	
		
		double a=getAngle();
		
		StateSprite s=AnimUtils.getSprite(getSource());
		
		StepBackState st=new StepBackState(a);
		s.setState(st);
	
		
		
		
		
	}
}
