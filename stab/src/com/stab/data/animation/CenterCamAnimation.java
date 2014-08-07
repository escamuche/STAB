package com.stab.data.animation;

import com.stab.client.slick.GameScreen;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;

public class CenterCamAnimation extends Animation{
	
	public static final String ID=VisualEffect.CENTER_CAM_ANIMATION;
	
	public CenterCamAnimation() {
		setBlocking(true);
		setTime(800);
	}
	
	public void start() {
		super.start();
		StateSprite s=AnimUtils.getSprite(getSource());
		((GameScreen)s.getScreen()).centerViewCam(getSource());
		
	}
}
