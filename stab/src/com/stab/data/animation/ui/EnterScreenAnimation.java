package com.stab.data.animation.ui;

import com.stab.adventure.Game;
import com.stab.common.Constants;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.ui.states.UIStateSet;
import com.tien.princess.engine.sprite.ui.states.animating.MoveToAnimatingState;

public class EnterScreenAnimation  extends Animation{

	public static final String ID="ENTERSCREEN_ANIMATION";
	
	public EnterScreenAnimation() {
		setBlocking(false);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		StateSprite s=AnimUtils.getSprite(getSource());
		s.setVisible(true);
		MoveToAnimatingState st= new MoveToAnimatingState(s.getPos(), (int)getTime(), UIStateSet.NORMAL);
		int i=getIntParam(0);
		if (i==Constants.LEFT)
			s.setPos(-s.getWidth()-1,s.getY());
		if (i==Constants.RIGHT)
			s.setPos(Game.WIDTH+1,s.getY());
		s.setState(st);
		
	}
	
}