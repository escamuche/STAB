package com.stab.data.animation;

import java.awt.Point;

import com.stab.client.slick.base.util.PaintUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.data.animation.state.ThrustState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.StateSet;

public class ThrustAnimation extends OnTargetAnimation{

	public static final String ID="THRUST_ANIMATION";
	
	public ThrustAnimation() {
		setBlocking(false);
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		
		
		
		String img=getParam(1);
		
		Point origin=getOriginPoint();
	
		
		StabSprite icon=new StabSprite();
		icon.setPos(origin);
		icon.setSize(64,64);
		icon.setRef(AnimUtils.getSprite(getSource()));
	
		
		double a=getAngle();
		
	
		icon.setPainter(PaintUtils.getPainter(img));
	
		
		
		((ValuePainter)icon.getPainter()).setRotation((float)Math.toDegrees(a));
		
		
		icon.setA(a);
		icon.setR(0);

		ThrustState st= new ThrustState(1000);
		st.setTimed(getTime(), StateSet.DESTROYED);

		icon.setState(st);
		
		AnimUtils.getScreen(getSource()).add(icon);
	}
}

