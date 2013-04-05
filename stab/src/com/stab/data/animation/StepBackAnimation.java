package com.stab.data.animation;

import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.animation.state.LungeState;
import com.stab.data.animation.state.StepBackState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;

public class StepBackAnimation extends OnTargetAnimation{

	public static final String ID="STEPBACK_ANIMATION";
	
	public StepBackAnimation() {
		setBlocking(false);
		setTime(700);
	}
	
	@Override
	public void start() {
		super.start();
	
		
		double a=getAngle();
		
		Token_sprite s=AnimUtils.getSprite(getSource());
		
		StepBackState st=new StepBackState(a);
		s.setState(st);
	
		
		
		
		
	}
}
