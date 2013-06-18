package com.stab.data.animation.state;

import com.stab.client.slick.base.updaters.SyncState;
import com.stab.common.value.InterpolatorValueProvider;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.TagPoint;
import com.tien.princess.engine.sprite.common.states.ValueState;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;

public class StepBackState extends ValueState {
	
	double a;
	
	public StepBackState(double a) {
		super(true);
		super.setTimed(700, SyncState.ID);
		this.a=a+Math.PI;
		InterpolatorValueProvider r= new InterpolatorValueProvider(0,0,300,32,600,32,700,0);
		setRadius(r);
		setRotation((float)this.a);
		addUpdater(new Orbit());
	//	System.out.println("stepback: "+Math.toDegrees(a)+" > "+Math.toDegrees(this.a));
	}
	
	@Override
	public void enter(Sprite sprite) {
		super.enter(sprite);
		TagPoint p= new TagPoint();
		p.setPos(sprite.getPos());
		sprite.setRef(p);
		
	}
	
	

}