package com.stab.base.info;

import java.awt.Point;
import java.util.Random;

import com.stab.base.info.props.CDoor;
import com.stab.base.info.props.Slab;
import com.stab.common.utils.PathUtils;
import com.stab.model.info.base.Wall;
import com.stab.model.info.base.rndgen.Connector;

public class StabConnector extends Connector{
	
	public static final String ID = Connector.ID;

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
		case 3: place(p,CDoor.ID,PathUtils.rotateR(dir, 2));
				p=PathUtils.advancePoint(p, dir);
				place(p,CDoor.ID,PathUtils.rotateR(dir, 2));
				break;
		case 8: place(p,Slab.ID,PathUtils.rotateR(dir, 4));
				p=PathUtils.advancePoint(p, dir);
				place(p,Slab.ID,dir);
				break;
		}
	}
	
	
	
	
	
	
}
