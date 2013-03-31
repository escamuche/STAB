package com.stab.data.animation;

import java.awt.Point;

import com.stab.client.slick.base.updaters.SyncState;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.animation.state.LungeState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.sprite.common.states.ValueState;

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
