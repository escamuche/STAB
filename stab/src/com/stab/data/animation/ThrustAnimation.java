package com.stab.data.animation;

import java.awt.Point;

import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.common.value.InterpolatorValueProvider;
import com.stab.data.animation.state.LungeState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.states.ValueState;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;
import com.tien.princess.engine.utils.PaintUtils;

public class ThrustAnimation extends OnTargetAnimation{

	public static final String ID="THRUST_ANIMATION";
	
	public ThrustAnimation() {
		setBlocking(false);
		setTime(1000);
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

	//	ThrustState st= new ThrustState(1000);
		

		
		ValueState st= new ValueState();
		st.setTimed(getTime(), StateSet.DESTROYED);
		
		InterpolatorValueProvider r= new InterpolatorValueProvider(0,0,200,-16,400,32,600,32,1000,0);
	//	InterpolatorValueProvider r= new InterpolatorValueProvider(0,0,2000,32,5000,0);
		st.setRadius(r);
		st.addUpdater(new Orbit());
		
		icon.setState(st);
		
		AnimUtils.getScreen(getSource()).add(icon);
	}
}

