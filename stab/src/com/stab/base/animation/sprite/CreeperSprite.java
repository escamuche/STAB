package com.stab.base.animation.sprite;

import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.states.ValueState2;
import com.tien.princess.engine.sprite.common.updaters.conditions.OnSolid;
import com.tien.princess.engine.sprite.common.updaters.move.Move;
import com.tien.princess.engine.sprite.common.updaters.particle.ParticleSprite;

public class CreeperSprite extends StateSprite implements ParticleSprite{

	@Override
	protected void init() {
		super.init();
		ValueState2 st= new ValueState2(false);
		st.setId("ROAM");
		st.addUpdater(new Move());
		st.addUpdater(new OnSolid(StateSet.DESTROYED));
		addState(st);
		
		setState(st);
	}
	
}
