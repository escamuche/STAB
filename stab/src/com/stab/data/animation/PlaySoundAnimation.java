package com.stab.data.animation;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;

public class PlaySoundAnimation extends Animation {

	public static final String ID=VisualEffect.PLAY_SOUND_ANIMATION;
	
	public PlaySoundAnimation() {
		setTime(0);
	}
	
	@Override
	public void start() {
		super.start();
		
		String snd=getParam(0);
		StateSprite s=AnimUtils.getSprite(getSource());
		
		if (s!=null)
			if (s.getScreen()!=null){
				
				s.getScreen().playSound(snd);
			}
	
		
	}
	
	

}
