package com.stab.data.animation;

import com.stab.data.animation.state.LungeState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.sprite.StateSprite;

public class LungeAnimation  extends OnTargetAnimation{

	public static final String ID="LUNGE_ANIMATION";
	
	public LungeAnimation() {
		setBlocking(false);
		setTime(700);
	}
	
	@Override
	public void start() {
		super.start();
	
		
		double a=getAngle();
		
		StateSprite s=AnimUtils.getSprite(getSource());
		
		LungeState st=new LungeState(a);
		s.setState(st);
	
		
		
		
		
	}
}
