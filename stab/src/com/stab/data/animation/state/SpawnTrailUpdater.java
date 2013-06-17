package com.stab.data.animation.state;

import java.util.Arrays;
import java.util.Collection;

import com.stab.client.slick.base.visualobjects.StabSprite;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.updaters.spawn.SpawnUpdater;
import com.tien.princess.engine.utils.PaintUtils;

public class SpawnTrailUpdater extends SpawnUpdater {


	public SpawnTrailUpdater() {
		setEvery(10);
	}	
	
	public Collection<Sprite> createSpawn(Sprite sprite){
		StabSprite s=new StabSprite();
		s.setPainter(PaintUtils.getPainter("PARTICLE#effects/bluetrail"));
		s.setState(new BasicAnimState(450));
		return Arrays.asList((Sprite)s);
	}
	
}
