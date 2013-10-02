package com.stab.data.animation.sprite;

import org.newdawn.slick.Color;

import com.stab.common.utils.Roll;
import com.stab.data.utils.AnimUtils;
import com.tien.princess.engine.sprite.base.PixelParticle;
import com.tien.princess.engine.sprite.base.TrailSprite;
import com.tien.princess.engine.sprite.common.painters.SimpleImagePainter;
import com.tien.princess.engine.sprite.common.updaters.angle.AngleToRotation;
import com.tien.princess.engine.sprite.common.updaters.angle.MoveA;
import com.tien.princess.engine.sprite.common.updaters.angle.MoveR;
import com.tien.princess.engine.sprite.common.updaters.particle.ParticleSprite;
import com.tien.princess.engine.sprite.factory.ParticleFactory;

public class StabParticleFactory extends ParticleFactory {

	public static final String GLOWORB="GLOWORB";
	public static final String GLASSSHARD="GLASSSHARD";
	
	@Override
	protected ParticleSprite getParticle(String string, Color c) {
	
		
		if (GLOWORB.equals(string)){
			PixelParticle p=getDefaultParticle(c,5000);
			p.bounce();
			SimpleImagePainter pt= new SimpleImagePainter("effects/part12");
			p.setSa(0.01f);
			p.getVState().addUpdater(new MoveA());
			p.getVState().addUpdater(new AngleToRotation());
			p.fade();
			p.setPainter(pt);
			pt.setScale(0.4f);
			TrailSprite trail = new TrailSprite(c,12,6,50);
			trail.setRef(p);
			AnimUtils.getScreen().add(trail);
			return p;
		}
		if (GLASSSHARD.equals(string)){
			PixelParticle p=getDefaultParticle(c,2000);
			p.bounce();
			int i=Roll.roll(5);
			SimpleImagePainter pt= new SimpleImagePainter("effects/glass"+i);
			p.setSr(-0.01f/Roll.d100());
			p.addUpdater(new MoveR(0, 10));
			p.getVState().addUpdater(new AngleToRotation());
			p.fade(75);
			p.setPainter(pt);
			
			//TrailSprite trail = new TrailSprite(c,12,6,50);
			//trail.setRef(p);
			//AnimUtils.getScreen().add(trail);
			return p;
		}
		
		return super.getParticle(string, c);
	}
	
	
	
}
