package com.stab.data.animation;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
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
		
		Token_sprite s=AnimUtils.getSprite(getSource());
		StabSprite icon=new StabSprite();
		icon.setPos(getOriginPoint().x,getOriginPoint().y-s.getWidth()/2-16);
		icon.setSize(64,64);
		Painter p=PaintUtils.getPainter("PARTICLE#alert");
		icon.setPainter(p);
		icon.setState(new BasicAnimState(this.getTime()));
		((GameScreen)s.getScreen()).add(icon);
	}
	
}
