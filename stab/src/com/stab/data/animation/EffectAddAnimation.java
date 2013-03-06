package com.stab.data.animation;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.util.PaintUtils;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.common.Constants;
import com.stab.data.animation.state.TestAnimState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.Resources;
import com.tien.princess.engine.sprite.StateSprite;

public class EffectAddAnimation  extends Animation {

	public static final String ID=VisualEffect.EFFECT_ADD_ANIMATION;
	
	public EffectAddAnimation() {
		setBlocking(true);
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		String img=getParam(0);
		Token_sprite s=AnimUtils.getSprite(getSource());
		StateSprite icon=new StateSprite();
		icon.setPos(s.getX()+s.getWidth()/2,s.getY()+16);
		icon.setSize(64,64);
		icon.setSpeed(0, -0.05f);
		icon.setPainter(PaintUtils.getPainter(img));
		icon.setState(new TestAnimState(this.getTime()));
		((GameScreen)s.getScreen()).add(icon);
	}
}
