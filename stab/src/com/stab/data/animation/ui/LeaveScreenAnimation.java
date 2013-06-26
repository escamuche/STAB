package com.stab.data.animation.ui;

import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.ui.states.UIStateSet;
import com.tien.princess.engine.sprite.ui.states.animating.LeaveAnimatingState;

public class LeaveScreenAnimation extends Animation{

	public static final String ID="LEAVESCREEN_ANIMATION";
	
	public LeaveScreenAnimation() {
		setBlocking(false);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		StateSprite s=AnimUtils.getSprite(getSource());
		int i=getIntParam(0);
		LeaveAnimatingState st= new LeaveAnimatingState(i,(int)getTime(), UIStateSet.NORMAL);
		s.setState(st);
	}
	
}
