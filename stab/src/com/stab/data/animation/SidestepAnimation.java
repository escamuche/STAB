package com.stab.data.animation;

import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.animation.state.SidestepState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;

public class SidestepAnimation extends OnTargetAnimation{

	public static final String ID="SIDESTEP_ANIMATION";
	
	public SidestepAnimation() {
		setBlocking(false);
		setTime(700);
	}
	
	@Override
	public void start() {
		super.start();
	
		
		double a=getAngle();
		
		Token_sprite s=AnimUtils.getSprite(getSource());
		
		SidestepState st=new SidestepState(a);
		s.setState(st);
	
		
		
	}
}
