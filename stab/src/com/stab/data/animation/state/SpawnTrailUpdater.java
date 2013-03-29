package com.stab.data.animation.state;

import com.stab.client.slick.base.util.PaintUtils;
import com.stab.client.slick.base.visualobjects.StabSprite;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.updaters.misc.SpawnUpdater;

public class SpawnTrailUpdater extends SpawnUpdater {


	public SpawnTrailUpdater() {
		setEvery(10);
	}	
	
	public Sprite spawn(Sprite sprite){
		StabSprite s=new StabSprite();
		s.setPainter(PaintUtils.getPainter("PARTICLE#bluetrail"));
		s.setState(new BasicAnimState(450));
		return s;
	}
	
}
