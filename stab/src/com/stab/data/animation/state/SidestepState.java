package com.stab.data.animation.state;

import com.stab.client.slick.base.updaters.SyncState;
import com.stab.common.value.InterpolatorValueProvider;
import com.stab.util.Roll;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.TagPoint;
import com.tien.princess.engine.sprite.common.states.ValueState;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;

public class SidestepState extends ValueState {
	
	double a;
	
	public SidestepState(double a) {
		super.setTimed(700, SyncState.ID);
		this.a=a;
		if (Roll.d2()==1)
			a=a+Math.PI;
		else
			a=a-Math.PI;
		
		InterpolatorValueProvider r= new InterpolatorValueProvider(0,0,300,32,600,32,700,0);
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
