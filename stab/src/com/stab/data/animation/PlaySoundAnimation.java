package com.stab.data.animation;

import java.util.Collection;

import com.stab.data.StabInit;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.Sprite;
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
