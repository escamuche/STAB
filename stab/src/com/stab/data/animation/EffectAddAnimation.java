package com.stab.data.animation;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.common.Constants;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.Animation;
import com.stab.model.info.trait.base.VisualEffect;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.base.AttachedParticleSprite;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.states.base.ClearParticlesState;
import com.tien.princess.engine.utils.PaintUtils;

public class EffectAddAnimation  extends Animation {

	public static final String ID=VisualEffect.EFFECT_ADD_ANIMATION;
	
	public EffectAddAnimation() {
		setBlocking(true);
		setTime(1200);
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
		StateSprite icon=new StateSprite();
	/*	icon=new AttachedParticleSprite();
		BasicAnimState st=new BasicAnimState(this.getTime());
		st.setTimed(this.getTime(), ClearParticlesState.ID);
		icon.setState(st);
		/**/
		icon.setDesiredLayer(Constants.OVERMAP);
		icon.setPos(s.getCenter());
		icon.setSize(64,64);
	//	icon.setSpeed(0, -0.05f);
		icon.setPainter(PaintUtils.getPainter("PARTICLE#effects/buffOn#"+img));
		icon.setState(new BasicAnimState(this.getTime()));
		((GameScreen)s.getScreen()).add(icon);
	}
}
