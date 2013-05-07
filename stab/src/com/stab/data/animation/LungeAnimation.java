package com.stab.data.animation;

import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.animation.state.LungeState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;

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
		
		Token_sprite s=AnimUtils.getSprite(getSource());
		
		LungeState st=new LungeState(a);
		s.setState(st);
	
		
		
		
		
	}
}
