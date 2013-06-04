package com.stab.data.animation;

import java.awt.Point;

import org.newdawn.slick.Color;

import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.common.value.Simple2PointValueProvider;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.sprite.base.TrailSprite;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.State;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.updaters.angle.MoveA;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;
import com.tien.princess.engine.utils.PaintUtils;

public class SwingAnimation extends OnTargetAnimation{

	public static final String ID="SWING_ANIMATION";
	
	public SwingAnimation() {
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
	
		
		double a=getAngle()-Math.toRadians(120);
		
	
		icon.setPainter(PaintUtils.getPainter(img));
	
		Simple2PointValueProvider sp= new Simple2PointValueProvider(0,240);
		sp.setDisp((float)Math.toDegrees(getAngle())-120);
		sp.setMax(getTime());
		
		((ValuePainter)icon.getPainter()).setRotation(sp);
		
		//((ValuePainter)icon.getPainter()).setRotation((float)Math.toDegrees(getAngle()));
		
		icon.setA(a);
		icon.setSa((float)((Math.toRadians(240)/getTime())));
		icon.setR(32);

		State st= new State();
		st.addUpdater(new Orbit());
		st.addUpdater(new MoveA());
		st.setTimed(getTime(), StateSet.DESTROYED);

		icon.setState(st);
		
		AnimUtils.getScreen(getSource()).add(icon);
		
	//	TrailSprite trail = new TrailSprite(Color.white,8,8,35);
	//	trail.setRef(icon);
	//	AnimUtils.getScreen(getSource()).add(trail);
		
	}
}
