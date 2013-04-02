package com.stab.data.animation;

import java.awt.Point;

import com.stab.client.slick.base.util.PaintUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.common.value.InterpolatorValueProvider;
import com.stab.common.value.Simple2PointValueProvider;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.State;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.updaters.angle.MoveA;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;

public class RSwingAnimation extends OnTargetAnimation{

public static final String ID="RSWING_ANIMATION";
	
	public RSwingAnimation() {
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
	
		
		double a=getAngle()+Math.toRadians(120);
		
	
		icon.setPainter(PaintUtils.getPainter(img));
	
	//	Simple2PointValueProvider sp= new Simple2PointValueProvider(0,240);
	//	sp.setDisp((float)Math.toDegrees(getAngle())-120);
	//	sp.setMax(getTime());
		InterpolatorValueProvider ip= new InterpolatorValueProvider(0,(float)a,getTime(),(float)(getAngle()-Math.toRadians(240)));
		
		((ValuePainter)icon.getPainter()).setRotation(ip);
		
		//((ValuePainter)icon.getPainter()).setRotation((float)Math.toDegrees(getAngle()));
		
		icon.setA(a);
		icon.setSa((float)(-(Math.toRadians(240)/getTime())));
		icon.setR(32);

		State st= new State();
		st.addUpdater(new Orbit());
		st.addUpdater(new MoveA());
		st.setTimed(getTime(), StateSet.DESTROYED);

		icon.setState(st);
		
		AnimUtils.getScreen(getSource()).add(icon);
	}
}
