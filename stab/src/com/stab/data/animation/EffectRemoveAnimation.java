package com.stab.data.animation;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.common.Constants;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.utils.PaintUtils;

public class EffectRemoveAnimation  extends Animation {

	public static final String ID=VisualEffect.EFFECT_REMOVE_ANIMATION;
	
	public EffectRemoveAnimation() {
		setBlocking(true);
		setTime(700);
	}
	
	@Override
	public void start() {
		super.start();
		String img=getParam(0);
		Token_sprite s=AnimUtils.getSprite(getSource());
		if (!s.isVisible()){
			setTime(0);
			return;
		}
		StabSprite icon=new StabSprite();
		((StabSprite)icon).setDesiredLayer(Constants.OVERMAP);
		icon.setPos(s.getCenter());
		icon.setSize(64,64);
	//	icon.setSpeed(0, -0.05f);
		icon.setPainter(PaintUtils.getPainter("PARTICLE#effects/buffOff#"+img));
		icon.setState(new BasicAnimState(this.getTime()));
		((GameScreen)s.getScreen()).add(icon);
	}

}
