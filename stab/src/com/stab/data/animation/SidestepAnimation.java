package com.stab.data.animation;

import com.stab.data.animation.state.SidestepState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.sprite.StateSprite;

public class SidestepAnimation extends OnTargetAnimation{

	public static final String ID="SIDESTEP_ANIMATION";
	
	public SidestepAnimation() {
		setTime(700);
	}
	
	@Override
	public void start() {
		super.start();
	
		
		double a=getAngle();
		
		StateSprite s=AnimUtils.getSprite(getSource());
		
		SidestepState st=new SidestepState(a);
		s.setState(st);
	
		
		
	}
}
