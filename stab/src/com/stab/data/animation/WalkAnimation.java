package com.stab.data.animation;

import java.awt.Point;

import com.stab.adventure.Game;
import com.stab.data.animation.state.MoveToPointState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.action.base.WalkToAction;
import com.stab.model.animation.OnTileAnimation;
import com.tien.princess.engine.sprite.StateSprite;

public class WalkAnimation extends OnTileAnimation {

	
	public static final String ID=WalkToAction.ANIMATION_ID;
	
	public WalkAnimation() {
		setBlocking(true);
		setTime(300);
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
		Point target=new Point(getTile().x*Game.TILEWIDTH,getTile().y*Game.TILEHEIGHT);
		MoveToPointState st=new MoveToPointState(target,getTime());
		s.setState(st);
	}
	
}
