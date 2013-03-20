package com.stab.data.animation.state;

import com.stab.client.slick.base.updaters.SyncState;
import com.stab.common.value.Simple2PointValueProvider;
import com.stab.common.value.SineValueProvider;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.common.states.ValueState;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;

public class ThrustState extends ValueState {
	
	public ThrustState(int time) {
		super.setTimed((int)time, SyncState.ID);
		SineValueProvider p=new SineValueProvider();
		p.setScale(32);
		p.setFactor(10000);
		this.setRadius(p);
		p.setMax(time);
		this.addUpdater(new Orbit());
		
	}
	


}
