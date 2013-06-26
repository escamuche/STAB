package com.stab.data.animation;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.common.value.InterpolatorValueProvider;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;
import com.tien.princess.engine.utils.PaintUtils;

public class BlockAnimation  extends OnTargetAnimation {

	public static final String ID="BLOCK_ANIMATION";
	
	public BlockAnimation() {
		setBlocking(false);
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		String img=getParam(1);
		double a=getAngle();
		
		StateSprite s=AnimUtils.getSprite(getSource());
		StabSprite icon=new StabSprite();
		icon.setPos(getOriginPoint());
		icon.setSize(64,64);
		Painter p=PaintUtils.getPainter(img);
		if (p instanceof ValuePainter){
			((ValuePainter)p).setRotation((float)Math.toDegrees(a));
			((ValuePainter)p).setAlpha(new InterpolatorValueProvider(0,0f,200,1.0f,900,1.0f,1000,0f));
		}
		icon.setRef(s);
		icon.setR(32);
		icon.setA(a);
		icon.setPainter(p);
		BasicAnimState st=new BasicAnimState(this.getTime());
		st.addUpdater(new Orbit());
		icon.setState(st);
		((GameScreen)s.getScreen()).add(icon);
	}
}
