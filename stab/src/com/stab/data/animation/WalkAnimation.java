package com.stab.data.animation;

import java.awt.Point;

import com.stab.adventure.Game;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.animation.state.MoveToPointState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.action.base.WalkToAction;
import com.stab.model.animation.OnTileAnimation;

public class WalkAnimation extends OnTileAnimation {

	
	public static final String ID=WalkToAction.ANIMATION_ID;
	
	public WalkAnimation() {
		setBlocking(true);
		setTime(300);
	}
	
	@Override
	public void start() {
		super.start();
		Token_sprite s=AnimUtils.getSprite(getSource());
		Point target=new Point(getTile().x*Game.TILEWIDTH,getTile().y*Game.TILEHEIGHT);
		MoveToPointState st=new MoveToPointState(target,getTime());
		s.setState(st);
	}
	
}
