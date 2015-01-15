package com.stab.data.animation.sprite;

import com.stab.client.slick.base.visualobjects.token.CreatureToken_sprite;
import com.tien.princess.engine.Screen;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.states.ValueState2;
import com.tien.princess.engine.sprite.common.updaters.DefaultUpdater;
import com.tien.princess.engine.sprite.common.updaters.meta.Every;
import com.tien.princess.engine.sprite.common.updaters.particle.GravityWell;

public class CreeperFlock extends StateSprite {
	
	@Override
	protected void init() {
		super.init();
		ValueState2 st= new ValueState2(false);
		st.setId("STAY");
		addState(st);
		st.addUpdater(new GravityWell(0.01f,40));
		st.addUpdater(new Every(9000, new DefaultUpdater() {
			
			@Override
			public String update(Screen world, Sprite sprite, int t) {
				for (Sprite to:world.getSprites(CreatureToken_sprite.class)){
					CreatureToken_sprite c=(CreatureToken_sprite)to;
					if (c.getCenter().distanceSq(getPos())<(100*100))
						return "FLEE";
				}
				return null;
			}
		}));
		this.setCurrentState(st);
		ValueState2 st2= new ValueState2();
		st2.setId("FLEE");
		st.addUpdater(new GravityWell(-0.04f,40));
		st2.setTimed(10, StateSet.DESTROYED);
		addState(st2);
	}

	
	
	
}
