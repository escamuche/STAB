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
		int md=80;
		boolean b=false;
		int tries=0;
		while(!b && tries<5){
			t=new Point(p.x+r.nextInt(md)-md,p.y+r.nextInt(md)-md);
		//	System.out.println(dist +"  vs "+(t.distanceSq(getOriginPoint())));
			if (dist<(t.distanceSq(getOriginPoint()))){
				b=true;
			}else{
				tries++;
			}
		}
		
		return t;
	}

}
