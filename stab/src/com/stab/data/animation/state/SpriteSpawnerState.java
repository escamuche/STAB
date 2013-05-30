package com.stab.data.animation.state;

import java.util.Collection;

import com.stab.data.StabInit;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.SpriteFactory;

public class SpriteSpawnerState extends ExplodeState {

	SpriteFactory factory;
	
	public SpriteSpawnerState(String spark,long time){
		this(spark,time,false,null);
	}
	public SpriteSpawnerState(String spark,long time,boolean reverseAngle) {
		this(spark,time,reverseAngle,null);
	}
	public SpriteSpawnerState(String spark,long time,String sound) {
		this(spark,time,false,sound);
	}
	public SpriteSpawnerState(String spark,long time,boolean reverseAngle,String sound) {
		super(spark,time,reverseAngle,sound);
		
	}
	
	public void setFactory(SpriteFactory factory) {
		this.factory = factory;
	}
	public SpriteFactory getFactory() {
		return factory;
	}
	
	
	public void spawn(Sprite sprite){
		Collection<Sprite> sprites= StabInit.getSpriteFactory().getSprites(spark);
		if (sprites==null){
			return;
		}
		Sprite first=sprites.iterator().next();
		first.setPos(sprite.getPos());
		
	
		
		double angle=sprite.getA();
		if(reverseAngle && sprite.getRef()!=null)
			angle=Math.atan2(-sprite.getRef().getCenter().getY()-sprite.getY(), sprite.getRef().getCenter().getX()-sprite.getX());
				
		first.setA(angle);
		for (Sprite s:sprites)
			sprite.getScreen().addSprite(s);
		if (sound!=null)
			sprite.getScreen().playSound(sound);
	}
}
