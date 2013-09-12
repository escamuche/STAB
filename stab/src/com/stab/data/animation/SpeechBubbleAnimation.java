package com.stab.data.animation;

import com.stab.client.slick.GameScreen;
import com.stab.data.animation.sprite.SpeechBubble;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;

public class SpeechBubbleAnimation extends Animation {

	
	public static final String ID=VisualEffect.SPEECH_ANIMATION;
	
	public SpeechBubbleAnimation() {
		setBlocking(false);
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		String txt=getParam(0);
	
		String img=getParam(0);
		
		StateSprite s=AnimUtils.getSprite(getSource());
		if (!s.isVisible()){
			setTime(0);
			return;
		}
		SpeechBubble icon=new SpeechBubble();
		
		icon.setRef(s);
		
		
		//icon.setPos(getOriginPoint());
		//icon.setSize(64,64);
		
		long time=txt.length()*30;
		setTime(time);
		
		icon.setText(txt);
		
		if (img!=null)
			icon.setIcon(img);
		
		((GameScreen)s.getScreen()).add(icon);
	}

}
