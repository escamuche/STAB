package com.stab.data.animation;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.model.animation.Animation;
import com.tien.princess.engine.sprite.StateSprite;

public class OpenDoorAnimation  extends Animation {

	public static final String ID="OPENDOOR_ANIMATION";
	
	public OpenDoorAnimation() {
		setBlocking(true);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		
		StateSprite s=AnimUtils.getSprite(getSource());
		s.setFrame(0);
	}
	
	@Override
	public void update(int t) {
		super.update(t);
		StateSprite s=AnimUtils.getSprite(getSource());
		int f=(int)getAnimT()/100;
		if (f>4)
			f=4;
		s.setFrame(f);
	}
	
	@Override
	public void end() {
		super.end();
		StateSprite s=AnimUtils.getSprite(getSource());
		s.setFrame(4);
	}
	
}
