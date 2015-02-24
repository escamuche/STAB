package com.stab.base.animation;

import java.awt.Point;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.common.value.Simple2PointValueProvider;
import com.stab.model.animation.OnTileAnimation;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.State;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.updaters.angle.MoveA;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;
import com.tien.princess.engine.utils.PaintUtils;

public class SwingAtAnimation extends OnTileAnimation{

	public static final String ID="SWING_AT_ANIMATION";
	
	public SwingAtAnimation() {
		setTime(500);
	}
	
	@Override
	public void start() {
		super.start();
		
		
		
		String img=getParam(2);
		
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

