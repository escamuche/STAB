package com.stab.data.animation.state;

import com.stab.client.slick.base.updaters.SyncState;
import com.stab.common.value.InterpolatorValueProvider;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.TagPoint;
import com.tien.princess.engine.sprite.common.states.ValueState;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;

public class LungeState extends ValueState {
	
	double a;
	
	public LungeState(double a) {
		super(true);
		super.setTimed(700, SyncState.ID);
		this.a=a;
		InterpolatorValueProvider r= new InterpolatorValueProvider(0,0,100,-4,400,32,600,32,700,0);
		setRadius(r);
		addUpdater(new Orbit());
		
	}
	
	@Override
	public void enter(Sprite sprite) {
		super.enter(sprite);
		TagPoint p= new TagPoint();
		p.setPos(sprite.getPos());
		sprite.setRef(p);
		sprite.setA(a);
	}
	
	

}
