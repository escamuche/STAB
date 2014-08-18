package com.stab.data.animation;

import java.awt.Point;

import org.newdawn.slick.Color;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.common.Constants;
import com.stab.common.utils.Roll;
import com.stab.data.animation.sprite.MagicMissileSprite;
import com.stab.model.animation.OnTargetAnimation;
import com.stab.model.basic.Sprite;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.base.TrailSprite;

public class MagicMissileAnimation extends OnTargetAnimation{

	public static final String ID="MAGICMISSILE_ANIMATION";
	
	
	double ang1[]=new double[]{0,-Constants.ANGLE_30,+Constants.ANGLE_30,-Constants.ANGLE_45,Constants.ANGLE_45};
	double ang2[]=new double[]{-Constants.ANGLE_30,+Constants.ANGLE_30,-Constants.ANGLE_45,Constants.ANGLE_45};
	
	public MagicMissileAnimation() {
		setBlocking(true);
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		
		
		
		
		int number=getIntParam(1);
		boolean block=getBooleanParam(2);
		
		Point origin=getOriginPoint();
		Point target=getTargetPoint();
		
		float speed=getSpeed();
		float distance=(float)origin.distance(target);
		long time=(long)((distance/speed)*1.1f);
		float ab=10-distance;
		if (ab<0)
			ab=0;
		ab=1.0f+(ab/10f);
		
		for (int f=0;f<number;f++){
		
			MagicMissileSprite icon=new MagicMissileSprite(time);
			icon.setBlocked(block);
			
			double a=getAngle();
			if (number%2==0)
				a=a+ab*ang2[f];
			else
				a=a+ab*ang1[f];
			
			icon.setR(speed+(Roll.d4()/(float)30));
			icon.setPos(origin);
			icon.setSize(64,64);
			icon.setA(a);
			icon.setTarget(AnimUtils.getSprite(getTarget()),true);
//	icon.setPainter(Resources.INSTANCE.getImage("tokens/door"),Constants.CENTER);
			AnimUtils.getScreen(getSource()).add(icon);
			
			TrailSprite trail = new TrailSprite(Color.cyan,12,6,50);
			trail.setRef(icon);
			AnimUtils.getScreen(getSource()).add(trail);
		}
		
		//setTime(time);
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
		return 0.1f;
	}
	
	@Override
	public long getTime(Sprite origin, Sprite t) {
		float speed=getSpeed();
		long time=(long)((origin.getPos().distance(t.getPos())/speed)*1.3);
		return time;
	}
	
}
