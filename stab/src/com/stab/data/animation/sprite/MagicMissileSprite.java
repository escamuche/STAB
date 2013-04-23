package com.stab.data.animation.sprite;

import org.newdawn.slick.Color;

import com.stab.client.slick.base.visualobjects.LightSprite;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.stab.data.animation.state.SpawnTrailUpdater;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.TagPoint;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.states.State;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.updaters.angle.CorrectAim;
import com.tien.princess.engine.sprite.common.updaters.angle.Vectorize;
import com.tien.princess.engine.sprite.common.updaters.misc.Reach;
import com.tien.princess.engine.sprite.common.updaters.move.Move;
import com.tien.princess.engine.utils.PaintUtils;

public class MagicMissileSprite extends LightSprite {

	
	
	public MagicMissileSprite(long t) {
		setLightOn(true);
		setLightIntensity(24);
		setLightColor(Color.blue);
		setPainter(PaintUtils.getPainter("PARTICLE#magicmissile"));
		
		BasicAnimState st=new BasicAnimState(t);
		st.addUpdater(new SpawnTrailUpdater());
		st.addUpdater(new CorrectAim(0.05));
		st.addUpdater(new Vectorize());
		st.addUpdater(new Move());
		st.addUpdater(new Reach("SPAWN",24));
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
	
	public void spawn(){
		StabSprite s=new StabSprite();
		s.setPos(this.getPos());
		s.setSize(64,64);
		s.setPainter(PaintUtils.getPainter("PARTICLE#blueSparks"));
		s.setState(new BasicAnimState(1000));
		getScreen().addSprite(s);
	}
	
	
	
	
}
