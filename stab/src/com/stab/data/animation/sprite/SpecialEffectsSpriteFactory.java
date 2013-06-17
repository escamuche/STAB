package com.stab.data.animation.sprite;

import java.util.Arrays;
import java.util.Collection;

import com.stab.common.Constants;
import com.stab.common.value.InterpolatorValueProvider;
import com.stab.data.animation.state.ExplodeState;
import com.tien.princess.engine.Resources;
import com.tien.princess.engine.sprite.AbstractSpriteFactory;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.AttachedParticleSprite;
import com.tien.princess.engine.sprite.base.BeamSprite;
import com.tien.princess.engine.sprite.base.ProyectileSprite;
import com.tien.princess.engine.sprite.common.updaters.sound.PlaySound;

public class SpecialEffectsSpriteFactory extends  AbstractSpriteFactory{

	
	public static final String BLUE_CAST="BLUECAST";
	public static final String BLUE_EXPLOSION="BLUEEXPLOSION";
	public static final String BLUE_CHANNEL="BLUECHANNEL";
	public static final String BLUE_IMPACT="BLUEIMPACT";
	public static final String BLUE_BEAM="BLUEBEAMT";
	
	
	public static final String FREEZE_EXPLOSION="FEEZEEXPLOSION";
	
	@Override
	public Collection<Sprite> getSprites(String type) {
		
		
		if (BLUE_CAST.equals(type)){
			ProyectileSprite s= new ProyectileSprite(2);
			s.setOnFire(new ExplodeState("PARTICLE#effects/blueCast","effects/FizzleNatureA"));
			return Arrays.asList((Sprite)s);
		}
		if (BLUE_EXPLOSION.equals(type)){
			AttachedParticleSprite s= new AttachedParticleSprite();
			s.setPainter("PARTICLE#effects/blueSparks");
			s.getCurrentState().addUpdater(new PlaySound("effects/IceCast"));
			return Arrays.asList((Sprite)s);
		}
		if (FREEZE_EXPLOSION.equals(type)){
			AttachedParticleSprite s= new AttachedParticleSprite();
			s.setPainter("PARTICLE#effectsfreeze");
			s.getCurrentState().addUpdater(new PlaySound("effects/IceCast"));
			return Arrays.asList((Sprite)s);
		}
		if (BLUE_CHANNEL.equals(type)){
			AttachedParticleSprite s= new AttachedParticleSprite();
			s.setPainter("PARTICLE#effects/blueChannel");
			return Arrays.asList((Sprite)s);
		}
		if (BLUE_BEAM.equals(type)){
			BeamSprite s= new BeamSprite();
			s.setImage(Resources.INSTANCE.getImage("effects/frostBeam"));
			s.setStyle(Constants.TILED);
			s.getFireState().setAlpha(new InterpolatorValueProvider(0,0.1f,100,0.8f));
			s.getFireState().setWidth(new InterpolatorValueProvider(0,0,200,16));
			s.getFadeState().setWidth(new InterpolatorValueProvider(0,16,400,16,600,0));
			s.getFadeState().setAlpha(new InterpolatorValueProvider(400,0.6f,600,0f));
			return Arrays.asList((Sprite)s);
		}
		
		return null;
	}
}
