package com.stab.data.animation.sprite;

import com.stab.client.slick.base.util.PaintUtils;
import com.stab.client.slick.base.visualobjects.LightSprite;
import com.stab.data.animation.state.SpawnTrailUpdater;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.updaters.angle.CorrectAim;
import com.tien.princess.engine.sprite.common.updaters.angle.Vectorize;
import com.tien.princess.engine.sprite.common.updaters.misc.Reach;
import com.tien.princess.engine.sprite.common.updaters.move.Move;

public class MagicMissileSprite extends LightSprite {

	public MagicMissileSprite(long t) {
		setLightOn(false);
		setLightIntensity(24);
		setPainter(PaintUtils.getPainter("PARTICLE#magicmissile"));
		
		BasicAnimState st=new BasicAnimState(t);
		st.addUpdater(new SpawnTrailUpdater());
		st.addUpdater(new CorrectAim(0.1));
		st.addUpdater(new Vectorize());
		st.addUpdater(new Move());
		st.addUpdater(new Reach( StateSet.DESTROYED));
		this.setState(st);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		//Spawnear efecto
	}
	
}
