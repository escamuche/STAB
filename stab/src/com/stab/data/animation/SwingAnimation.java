package com.stab.data.animation;

import java.awt.Point;

import com.stab.common.Constants;
import com.stab.common.value.Simple2PointValueProvider;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.Resources;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.State;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.updaters.angle.MoveA;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;

public class SwingAnimation extends OnTargetAnimation{

	public static final String ID="SWING_ANIMATION";
	
	public SwingAnimation() {
		setBlocking(true);
		setTime(600);
	}
	
	@Override
	public void start() {
		super.start();
		
		
		
		String img=getParam(1);
		
		Point origin=getOriginPoint();
	
		
		StateSprite icon=new StateSprite();
		icon.setPos(origin);
		icon.setSize(64,64);
		icon.setRef(AnimUtils.getSprite(getSource()));
	
		
		double a=getAngle()-Math.toRadians(120);
		
		System.out.println("Angle:"+a+" "+Math.toDegrees(a));
	
		icon.setPainter(Resources.INSTANCE.getImage(img),Constants.CENTERED);
	
		Simple2PointValueProvider sp= new Simple2PointValueProvider(-120,+120);
		sp.setDisp((float)Math.toDegrees(getAngle()));
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
	}
}
