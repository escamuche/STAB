package com.stab.data.animation;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.common.Constants;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.utils.PaintUtils;

public class AlertAnimation extends Animation {

public static final String ID=VisualEffect.ALERT_ANIMATION;
	
	public AlertAnimation() {
		setBlocking(false);
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		
		StateSprite s=AnimUtils.getSprite(getSource());
		if (!s.isVisible()){
			setTime(0);
			return;
		}
		StabSprite icon=new StabSprite();
		icon.setDesiredLayer(Constants.OVERMAP);
		icon.setPos(getOriginPoint().x,getOriginPoint().y-s.getWidth()/2-16);
		icon.setSize(64,64);
		Painter p=PaintUtils.getPainter("PARTICLE#effects/alert");
		icon.setPainter(p);
		icon.setState(new BasicAnimState(this.getTime()));
		((GameScreen)s.getScreen()).add(icon);
	}
	
}
