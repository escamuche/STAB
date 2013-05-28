package com.stab.data.animation.state;

import com.stab.client.slick.base.visualobjects.StabSprite;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.states.State;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.utils.PaintUtils;

public class ExplodeState extends State {

	String spark;
	boolean reverseAngle;
	String sound;
	long time;
	
	public ExplodeState(String spark,long time){
		this(spark,time,false,null);
	}
	public ExplodeState(String spark,long time,boolean reverseAngle) {
		this(spark,time,reverseAngle,null);
	}
	public ExplodeState(String spark,long time,String sound) {
		this(spark,time,false,sound);
	}
	public ExplodeState(String spark,long time,boolean reverseAngle,String sound) {
		this.setId("EXPLODE");
		this.spark=spark;
		setTimed(2, StateSet.DESTROYED);
		this.reverseAngle=reverseAngle;
		this.sound=sound;
		this.time=time;
	}
	
	public void enter(Sprite sprite) {
		spawn(sprite);
		super.enter(sprite);
	}
	
	
	public void spawn(Sprite sprite){
		StabSprite s=new StabSprite();
		s.setPos(sprite.getPos());
		s.setSize(64,64);
		
		s.setPainter(PaintUtils.getPainter(spark));
		
		double angle=sprite.getA();
		if(reverseAngle && sprite.getRef()!=null)
			angle=Math.atan2(-sprite.getRef().getCenter().getY()-sprite.getY(), sprite.getRef().getCenter().getX()-sprite.getX());
				
		((ValuePainter)(s.getPainter())).setRotation((float)Math.toDegrees(angle));
	
		s.setState(new BasicAnimState(time));
		sprite.getScreen().addSprite(s);
		if (sound!=null)
			sprite.getScreen().playSound(sound);
	}
}
