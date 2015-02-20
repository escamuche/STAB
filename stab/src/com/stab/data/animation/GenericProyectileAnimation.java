package com.stab.data.animation;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;

import com.stab.adventure.Game;
import com.stab.client.slick.base.util.AnimUtils;
import com.stab.model.animation.OnTileAnimation;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.pf.StabInit;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.base.ProyectileSprite;
import com.tien.princess.engine.sprite.base.TagPoint;

public class GenericProyectileAnimation extends OnTileAnimation {
	
public static final String ID=VisualEffect.GENERICPROYECTILE_ANIMATION;
	
	public GenericProyectileAnimation() {
		setBlocking(true);
		setTime(1000);
	}
	
	@Override
	public void start() {
		super.start();
		
		String img=getParam(2);
		
		Point origin=getOriginPoint();
		Point target=getTargetPoint();
		//System.out.println("IMG: "+img);
		Collection<Sprite> sprites= StabInit.getSpriteFactory().getSprites(img);
		if (sprites==null){
			setTime(0);
			return;
		}
		Sprite first=sprites.iterator().next();
		first.setPos(origin);
		
		
		if (getTargetPoint()!=null){
			TagPoint tp= new TagPoint();
			tp.setPos(getTargetPoint());
			first.setRef(tp);
			
			int rad=getIntParam(3);
			rad=rad*Game.TILEWIDTH/2;
			if (rad>0){
				double a= Math.atan2(target.y-origin.y, target.x-origin.x);
				first.setPos((int)(origin.x+rad*Math.cos(a)),(int)(origin.y+rad*Math.sin(a)));
			}
		}
		
		
	
		if (first instanceof ProyectileSprite){
			long distance= (long)first.getPos().distance(first.getRef().getPos());
			long time=(long)(distance/((ProyectileSprite)first).getSpeed());
			((ProyectileSprite)first).setTimeCap(time);
			setTime(time+250);
			
		}
		
		
		for (Sprite icon:sprites)
			AnimUtils.getScreen(getSource()).add(icon);
	
		
		
		
	}
	
	protected Point getOriginPoint(){
		StateSprite s=AnimUtils.getSprite(getSource());
		Point p=new Point((int)(s.getX()+s.getWidth()/2),(int)(s.getY()+s.getHeight()/2));
		return p;
	}
	
	protected Point getTargetPoint(){
		Rectangle t=new Rectangle(this.getTile().x*Game.TILEWIDTH,getTile().y*Game.TILEHEIGHT,Game.TILEWIDTH,Game.TILEHEIGHT);
		Point p=new Point((int)(t.getX()+t.getWidth()/2),(int)(t.getY()+t.getHeight()/2));;
		return p;
	}

}
