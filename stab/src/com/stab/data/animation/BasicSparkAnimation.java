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
		int t=getIntParam(1);
		if (t!=0)
			setTime(t);
		double a=0;
		try{
			a=getT(2, Double.class);
		}catch(Exception e){}
		Token_sprite s=AnimUtils.getSprite(getSource());
		StabSprite icon=new StabSprite();
		icon.setPos(getOriginPoint());
		icon.setSize(64,64);
		Painter p=PaintUtils.getPainter(img);
	
		if (p instanceof ValuePainter)
			((ValuePainter)p).setRotation((float)a);
		icon.setPainter(p);
		icon.setState(new BasicAnimState(this.getTime()));
		((GameScreen)s.getScreen()).add(icon);
	}
}
