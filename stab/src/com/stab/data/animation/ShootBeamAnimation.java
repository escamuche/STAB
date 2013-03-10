package com.stab.data.animation;

import java.awt.Point;

import com.stab.client.slick.base.util.PaintUtils;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.painters.ParticleSystemPainter;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;

public class ShootBeamAnimation extends OnTargetAnimation{

	public static final String ID="SHOOTBEAM_ANIMATION";
	
	public ShootBeamAnimation() {
		setBlocking(true);
		setTime(1400);
	}
	
	@Override
	public void start() {
		super.start();
		
		
		
		String img=getParam(1);
		
		Point origin=getOriginPoint();
		Point target=getTargetPoint();
		
		StateSprite icon=new StateSprite();  //No es stabsprite para saltarse la comprobacion de visible
		icon.setPos(origin);
		icon.setSize(64,64);
		
		float speed=0.3f;
		//TODO: leef speed de params tambien
		
		int distance=(int)origin.distance(target);
		long time=getTime();
	/*System.out.println("From "+origin+" to "+target);
		System.out.println("TIME:"+time +" = DISTANCE "+(origin.distance(target)+" / SPEED "+speed));
		System.out.println("IMAGEN: "+img);/**/
	//	img="effects/arrow";
	//	System.out.println("Angle: "+getAngle()+" = "+ ((float)Math.toDegrees(getAngle())));
		//icon.setPainter(Resources.INSTANCE.getImage(img),Constants.CENTERED);
		icon.setPainter(PaintUtils.getPainter(img));
		//icon.setPainter(Color.red);
		((ValuePainter)icon.getPainter()).setRotation((float)Math.toDegrees(getAngle()));
		((ParticleSystemPainter)icon.getPainter()).setBeamLimit(distance);
		BasicAnimState st=new BasicAnimState(time);
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