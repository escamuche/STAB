package com.stab.pf.animations.sprite;

import org.newdawn.slick.Color;

import com.stab.client.slick.base.visualobjects.LightSprite;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.TagPoint;
import com.tien.princess.engine.sprite.common.painters.ValuePainter;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.states.State;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.updaters.angle.CorrectAim;
import com.tien.princess.engine.sprite.common.updaters.angle.Vectorize;
import com.tien.princess.engine.sprite.common.updaters.conditions.OnReach;
import com.tien.princess.engine.sprite.common.updaters.move.Move;
import com.tien.princess.engine.utils.PaintUtils;

public class MagicMissileSprite extends LightSprite {

	boolean blocked=false;;
	
	@Override
	public void setSize(int w, int h) {
		// TODO Auto-generated method stub
		super.setSize(w, h);
	}
	
	public MagicMissileSprite(long t) {
		setLightOn(true);
		setLightIntensity(3);
		setLightColor(Color.blue);
		setPainter(PaintUtils.getPainter("PARTICLE#spells/magicMissile"));
		setSize(2,2);
		BasicAnimState st=new BasicAnimState(t);
	//	st.addUpdater(new SpawnTrailUpdater());
		st.addUpdater(new CorrectAim(0.015));
		st.addUpdater(new Vectorize());
		st.addUpdater(new Move());
		st.addUpdater(new OnReach("SPAWN",24));
		this.setState(st);
		
		State st2=new State(){
			@Override
			public void enter(Sprite sprite) {
				
				spawn();
				super.enter(sprite);
			}
		};
		st2.setId("SPAWN");
		st2.setTimed(2, StateSet.DESTROYED);
		addState(st2);
	}
	
	
	public void setTarget(Sprite s,boolean center){
		TagPoint h= new TagPoint();
		h.setPos(s.getPos());
		if (center)
			h.setPos(s.getCenter());
		setRef(h);
	}
	
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	public void spawn(){
		StabSprite s=new StabSprite();
		s.setPos(this.getPos());
		s.setSize(64,64);
		if (blocked)
			s.setPainter(PaintUtils.getPainter("PARTICLE#spells/mageShield"));
		else
			s.setPainter(PaintUtils.getPainter("PARTICLE#effects/blueSparks"));
		
		double angle=Math.atan2(-getRef().getCenter().getY()-getY(), getRef().getCenter().getX()-getX());
				
		((ValuePainter)(s.getPainter())).setRotation((float)Math.toDegrees(angle));
	
		s.setState(new BasicAnimState(1000));
		getScreen().addSprite(s);
	}
	
	
	
	
}
