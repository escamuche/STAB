package com.stab.data.animation.state;

import com.stab.client.slick.base.updaters.SyncState;
import com.stab.common.value.InterpolatorValueProvider;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.TagPoint;
import com.tien.princess.engine.sprite.common.states.ValueState2;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;

public class LootState extends ValueState2 {
	
	double a;
	
	
	
	public LootState() {
		super(true);
		super.setTimed(700, SyncState.ID);
	
	
		InterpolatorValueProvider r= new InterpolatorValueProvider(0,0,300,42,350,42,700,0);
		setRadius(r);
		setAngle((float)Math.toRadians(90));
		addUpdater(new Orbit());
		InterpolatorValueProvider r2= new InterpolatorValueProvider(0,0,180,320);
		setRotation(r2);
		
		//System.out.println("sidestep: "+Math.toDegrees(a)+" > "+Math.toDegrees(this.a));
	}
	
	@Override
	public void enter(Sprite sprite) {
		super.enter(sprite);
		TagPoint p= new TagPoint();
		p.setPos(sprite.getPos());
		sprite.setRef(p);
		//sprite.setA(a);
	}
	
	
}
