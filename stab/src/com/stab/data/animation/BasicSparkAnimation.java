package com.stab.data.animation;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.util.PaintUtils;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;

public class BasicSparkAnimation extends Animation {

	public static final String ID=VisualEffect.SPARK_ANIMATION;
	
	public BasicSparkAnimation() {
		setBlocking(false);
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		String img=getParam(0);
		Token_sprite s=AnimUtils.getSprite(getSource());
		StateSprite icon=new StateSprite();
		icon.setPos(getOriginPoint());
		icon.setSize(64,64);
		icon.setPainter(PaintUtils.getPainter(img));
		icon.setState(new BasicAnimState(this.getTime()));
		((GameScreen)s.getScreen()).add(icon);
	}
}
