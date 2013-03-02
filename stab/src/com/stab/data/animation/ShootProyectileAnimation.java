package com.stab.data.animation;

import java.awt.Point;

import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.common.Constants;
import com.stab.data.animation.state.MoveToPointState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.Resources;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.StateSet;

public class ShootProyectileAnimation extends OnTargetAnimation{

	public static final String ID="SHOOTPROYECTILE_ANIMATION";
	
	public ShootProyectileAnimation() {
		setBlocking(true);
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		
		
		
		String img=getParam(1);
		
		Point origin=getOriginPoint();
		Point target=getTargetPoint();
		
		StateSprite icon=new StateSprite();
		icon.setPos(origin);
		icon.setSize(64,64);
		
		float speed=0.2f;
		long time=(long)(origin.distance(target)/speed);
	/*	System.out.println("From "+origin+" to "+target);
		System.out.println("TIME:"+time +" = DISTANCE "+(origin.distance(target)+" / SPEED "+speed));
		System.out.println("IMAGEN: "+img);/**/
		img="effects/arrow";
		System.out.println("Angle: "+getAngle()+" = "+ ((float)Math.toDegrees(getAngle())));
		icon.setPainter(Resources.INSTANCE.getImage(img),Constants.CENTERED);
		//icon.setPainter(Color.red);
		((ValuePainter)icon.getPainter()).setRotation((float)Math.toDegrees(getAngle()));
		MoveToPointState st=new MoveToPointState(target,time);
		st.setTimed(time, StateSet.DESTROYED);
		icon.setState(st);
		setTime(time);
		AnimUtils.getScreen(getSource()).add(icon);
	}
	
	
	protected Point getOriginPoint(){
		Token_sprite s=AnimUtils.getSprite(getSource());
		Point p=new Point((int)(s.getX()+s.getWidth()/2),(int)(s.getY()+s.getHeight()/2));
		return p;
	}
	
	protected Point getTargetPoint(){
		Token_sprite t=AnimUtils.getSprite(getTarget());
		Point p=new Point((int)(t.getX()+t.getWidth()/2),(int)(t.getY()+t.getHeight()/2));;
		return p;
	}
	
}
