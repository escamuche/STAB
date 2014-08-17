package com.stab.data.animation;

import java.awt.Point;
import java.util.Random;

public class MissProyectileAnimation extends ShootProyectileAnimation {
	
	public static final String ID="MISSPROYECTILE_ANIMATION";
	
	
	@Override
	protected Point getTargetPoint() {
		Point p= super.getTargetPoint();
		Random r=new Random();
		double dist=p.distanceSq(getOriginPoint());
		Point t=null;
		boolean b=false;
		while(!b){
			t=new Point(p.x+r.nextInt(64)-64,p.y+r.nextInt(64)-64);
			if (dist+16<(t.distance(getOriginPoint())))
				b=true;
		}
		
		return t;
	}

}
