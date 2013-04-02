package com.stab.data.animation;

import java.awt.Point;

import com.stab.client.slick.base.util.PaintUtils;
import com.stab.client.slick.base.visualobjects.LightSprite;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.common.value.InterpolatorValueProvider;
import com.stab.data.animation.state.MoveToPointState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.StateSet;

public class ShootRotatingProyectileAnimation  extends OnTargetAnimation{

	public static final String ID="SHOOTROTATINGPROYECTILE_ANIMATION";
	
	public ShootRotatingProyectileAnimation() {
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
		
		float speed=0.3f;
		//TODO: leef speed de params tambien
		
		long time=(long)(origin.distance(target)/speed);
	/*System.out.println("From "+origin+" to "+target);
		System.out.println("TIME:"+time +" = DISTANCE "+(origin.distance(target)+" / SPEED "+speed));
		System.out.println("IMAGEN: "+img);/**/
	//	img="effects/arrow";
	//	System.out.println("Angle: "+getAngle()+" = "+ ((float)Math.toDegrees(getAngle())));
		//icon.setPainter(Resources.INSTANCE.getImage(img),Constants.CENTERED);
		icon.setPainter(PaintUtils.getPainter(img));
		//icon.setPainter(Color.red);
		
		InterpolatorValueProvider ip= new InterpolatorValueProvider(0,0,300,(float)(Math.PI*2));
		ip.setLoops(true);
		((ValuePainter)icon.getPainter()).setRotation(ip);
		MoveToPointState st=new MoveToPointState(target,time);
		st.setTimed(time, StateSet.DESTROYED);
		
		//st.addUpdater(new SpawnTrailUpdater());
		
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