package com.stab.data.animation;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.data.animation.state.BumpState;
import com.stab.model.action.base.WalkToAction;
import com.stab.model.animation.OnTileAnimation;
import com.tien.princess.engine.sprite.StateSprite;

public class BumpAnimation extends OnTileAnimation {

	
	public static final String ID=WalkToAction.BUMP_ANIMATION_ID;
	
	public BumpAnimation() {
		setBlocking(true);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		StateSprite s=AnimUtils.getSprite(getSource());
		/*
		if (!s.isVisible()){
			setTime(0);
			return;
		}
		/**/
		double a=getAngle();
		//Point target=new Point(getTile().x*Game.TILEWIDTH,getTile().y*Game.TILEHEIGHT);
		BumpState st=new BumpState(a);
		s.setState(st);
	}
	
}

