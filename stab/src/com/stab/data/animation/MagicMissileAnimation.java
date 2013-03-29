package com.stab.data.animation;

import java.awt.Point;

import com.stab.client.slick.base.util.PaintUtils;
import com.stab.client.slick.base.visualobjects.LightSprite;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.common.Constants;
import com.stab.data.animation.sprite.MagicMissileSprite;
import com.stab.data.animation.state.MoveToPointState;
import com.stab.data.utils.AnimUtils;
import com.stab.model.animation.OnTargetAnimation;
import com.tien.princess.engine.Resources;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.StateSet;

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
		
		
		Point origin=getOriginPoint();
		Point target=getTargetPoint();
		
		float speed=0.3f;
		long time=(long)(origin.distance(target)/speed);
		
		for (int f=0;f<number;f++){
		
			MagicMissileSprite icon=new MagicMissileSprite(time);
			double a=getAngle();
			if (number%2==0)
				a=a+ang2[f];
			else
				a=a+ang1[f];
			
			icon.setR(speed/2);
			icon.setPos(origin);
			icon.setSize(64,64);
			icon.setA(a);
			icon.setRef(AnimUtils.getSprite(getTarget()));
//	icon.setPainter(Resources.INSTANCE.getImage("tokens/door"),Constants.CENTER);
			AnimUtils.getScreen(getSource()).add(icon);
		}
		
		setTime(time);
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
