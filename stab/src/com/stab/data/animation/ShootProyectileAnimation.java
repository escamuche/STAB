package com.stab.data.animation;

import java.awt.Point;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.client.slick.base.visualobjects.LightSprite;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.data.animation.state.MoveToPointState;
import com.stab.model.animation.OnTargetAnimation;
import com.stab.model.basic.Sprite;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.utils.PaintUtils;

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
		
		StabSprite icon=new StabSprite();
		
		if (img.indexOf("magicmissile")!=-1){
			icon=new LightSprite();
			((LightSprite)icon).setLightIntensity(60);
		}
		
		icon.setPos(origin);
		icon.setSize(64,64);
		
		float speed=getSpeed();
		
		long time=(long)(origin.distance(target)/speed);
	/*System.out.println("From "+origin+" to "+target);
		System.out.println("TIME:"+time +" = DISTANCE "+(origin.distance(target)+" / SPEED "+speed));
		System.out.println("IMAGEN: "+img);/**/
	//	img="effects/arrow";
	//	System.out.println("Angle: "+getAngle()+" = "+ ((float)Math.toDegrees(getAngle())));
		//icon.setPainter(Resources.INSTANCE.getImage(img),Constants.CENTERED);
		icon.setPainter(PaintUtils.getPainter(img));
		//icon.setPainter(Color.red);
		((ValuePainter)icon.getPainter()).setRotation((float)Math.toDegrees(getAngle()));
		MoveToPointState st=new MoveToPointState(target,time);
		st.setTimed(time, StateSet.DESTROYED);
		
		//st.addUpdater(new SpawnTrailUpdater());
		
		icon.setState(st);
		setTime(time);
		AnimUtils.getScreen(getSource()).add(icon);
		
		
		
	}
	
	protected Point getOriginPoint(){
		StateSprite s=AnimUtils.getSprite(getSource());
		Point p=new Point((int)(s.getX()+s.getWidth()/2),(int)(s.getY()+s.getHeight()/2));
		return p;
	}
	
	protected Point getTargetPoint(){
		StateSprite t=AnimUtils.getSprite(getTarget());
		Point p=new Point((int)(t.getX()+t.getWidth()/2),(int)(t.getY()+t.getHeight()/2));;
		return p;
	}
	
	protected float getSpeed(){
		return 0.4f;
	}
	
	@Override
	public long getTime(Sprite origin, Sprite t) {
		float speed=getSpeed();
		long time=(long)(origin.getPos().distance(t.getPos())/speed);
		return time;
	}
	
}
