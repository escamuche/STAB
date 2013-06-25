package com.stab.data.animation;

import java.awt.Point;
import java.util.Random;

public class GenericProyectileMissAnimation extends GenericProyectileAnimation {

	public static final String ID="GENERICPROYECTILEMISS_ANIMATION";
	
	@Override
	protected Point getTargetPoint() {
		Point p= super.getTargetPoint();
		Random r=new Random();
		p.x=p.x+r.nextInt(64)-64;
		p.y=p.y+r.nextInt(64)-64;
		return p;
	}
}