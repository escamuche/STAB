package com.stab.pf.animations.sprite;

import org.newdawn.slick.Color;

import com.stab.client.slick.base.util.AnimUtils;
import com.stab.common.utils.Roll;
import com.tien.princess.engine.sprite.base.PixelParticle;
import com.tien.princess.engine.sprite.base.TrailSprite;
import com.tien.princess.engine.sprite.common.painters.SimpleImagePainter;
import com.tien.princess.engine.sprite.common.updaters.angle.AccelR;
import com.tien.princess.engine.sprite.common.updaters.angle.AngleToRotation;
import com.tien.princess.engine.sprite.common.updaters.angle.MoveA;
import com.tien.princess.engine.sprite.common.updaters.angle.MoveR;
import com.tien.princess.engine.sprite.common.updaters.angle.Vectorize;
import com.tien.princess.engine.sprite.common.updaters.particle.ParticleSprite;
import com.tien.princess.engine.sprite.factory.ParticleFactory;

public class StabParticleFactory extends ParticleFactory {

	public static final String GLOWORB="GLOWORB";
	public static final String GLASSSHARD="GLASSSHARD";
	//Pending
	public static final String BONESHARD="BONESHARD";
	public static final String WOODSHARD="WOODSHARD";
	public static final String ROCKCHIP="ROCKCHIP";
	
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
		//	return super.getParticle(string, c);
			PixelParticle p=getDefaultParticle(c,2000);
			p.bounce();
			int i=Roll.roll(5);
			SimpleImagePainter pt= new SimpleImagePainter("effects/glass"+i);
			
			p.setSr(-0.0002f/Roll.d100());
			//p.getVState().setRadiusSpeed(-0.00001f/Roll.d100(),0,-1f,1000);
			//p.getVState().setRadius(1.1f+(Roll.d100()/100),0,0,1000);
			p.addUpdater(new AccelR(-10f,0f,-0.000000004f));
			p.addUpdater(new MoveR(0, 10));
			p.addUpdater(new AngleToRotation());
			p.addUpdater(new Vectorize());
			p.fade(75);
			p.setPainter(pt);
			
			//TrailSprite trail = new TrailSprite(c,12,6,50);
			//trail.setRef(p);
			//AnimUtils.getScreen().add(trail);/**/
			return p;
		}
		
		return super.getParticle(string, c);
	}
	
	
	
}
