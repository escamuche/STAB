package com.stab.data.animation;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;

public class ExtraInfoAnimation extends Animation {

	
	public static final String ID=VisualEffect.EXTRAINFO_ANIMATION;
	
	public ExtraInfoAnimation() {
		setTime(0);
	}
	
	@Override
	public void start() {
		super.start();
		String txt=getParam(0);
	
		StateSprite s=AnimUtils.getSprite(getSource());
		
		String img=getParam(1);
		
		String snd=getParam(2);
		
	
		
		
		((AbstractGameScreen)s.getScreen()).setTooltip(txt,img);
		if (snd!=null)
			AnimUtils.getScreen(getSource()).playSound(snd);
	}

}

