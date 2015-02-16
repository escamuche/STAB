package com.stab.data.info;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import com.stab.common.utils.PathUtils;
import com.stab.data.info.props.CDoor;
import com.stab.data.info.props.Slab;
import com.stab.data.info.props.Wall;
import com.stab.model.basic.scenes.MapLogic;
import com.stab.model.info.Info;

public class Connector extends Info{

	public static final String ID="CONNECTOR";
	
	@Override
	public void enter() {
		super.enter();
		int dir=0; //vertical
		if (this.getWidth()>this.getHeight())
			dir=1; //horizontal
		
		//Check if everything is ok on the sides.
		MapLogic ml=this.getMapLogic();
		Rectangle r=new Rectangle(this.getX()-1,this.getY(),3,2);
		if (dir==1)
			r=new Rectangle(this.getX(),this.getY()-1,2,3);
		char c='X';
		if (dir==1)
			c='D';
		if (ml.isEmpty(r.getLocation(), (int)r.getWidth(),(int) r.getHeight()))
				placeConnection(c);
		else{
			System.out.println("Connector discarded");
		}
			
		destroy();	
		
	}

	protected void placeConnection(char dir) {
		
		Point p=this.getPos();
		int style=0;

		style=new Random().nextInt(9);
	//	System.out.println("Connector style "+style+ " at "+p.x+","+p.y+" dir "+dir);
		switch(style){
		case 0: break;
		case 4:
		case 5:
		case 1: place(p,CDoor.ID,PathUtils.rotateR(dir, 2));
				p=PathUtils.advancePoint(p, dir);
				place(p,Wall.ID,dir);
				break;
		case 6:
		case 7:
		case 2:	
				place(p,Wall.ID,dir);	
				p=PathUtils.advancePoint(p, dir);
				place(p,CDoor.ID,PathUtils.rotateR(dir, 2));
				break;
		case 3: place(p,Wall.ID,dir);
				p=PathUtils.advancePoint(p, dir);
				place(p,Wall.ID,dir);
				break;
		case 8: place(p,Slab.ID,PathUtils.rotateR(dir, 4));
				p=PathUtils.advancePoint(p, dir);
				place(p,Slab.ID,dir);
				break;
		}
	}
	
	protected Info place(Point pos,String type,char angle){
		Info e=null;
		if (type!=null)
			e=(Info)this.getEntityManager().createElement(type);
		
		e.setPos(pos);
		e.setAngle(angle);
		
		this.getScene().add(e);
		return e;
	}
	
	
	
	
	
	
}
