package com.stab.data.animation;

import com.stab.client.slick.AbstractGameScreen;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.data.animation.sprite.SpeechBubble;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;

public class SpeechBubbleAnimation extends Animation {

	
	public static final String ID=VisualEffect.SPEECH_ANIMATION;
	
	public SpeechBubbleAnimation() {
		setBlocking(true);
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		String txt=getParam(0);
	
		String img=getParam(1);
		
	//	System.out.println("Vamos a hacer un dialogo con "+txt+" | "+img);
		
		StateSprite s=AnimUtils.getSprite(getSource());
		if (!s.isVisible()){
			setTime(0);
			return;
		}
		SpeechBubble icon=new SpeechBubble();
		
		icon.setRef(s);
		
		
		//icon.setPos(getOriginPoint());
		//icon.setSize(64,64);
		
		
		
		icon.setText(txt);
		
		if (img!=null)
			icon.setIcon(img);
		
		
		
		setTime(icon.getCurrentState().getTimed()+200);
		
		((AbstractGameScreen)s.getScreen()).add(icon);
		
		icon.requestValidate();
	}

}
