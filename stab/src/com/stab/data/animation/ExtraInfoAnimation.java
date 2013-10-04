package com.stab.data.animation;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.data.utils.AnimUtils;
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
		
		
		
		
	
		
		
		((AbstractGameScreen)s.getScreen()).setTooltip(txt);
	}

}

