package com.stab.data.animation.sprite;

import java.util.Arrays;
import java.util.Collection;

import com.stab.data.animation.state.ExplodeState;
import com.tien.princess.engine.sprite.AbstractSpriteFactory;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.ProyectileSprite;

public class SpecialEffectsSpriteFactory extends  AbstractSpriteFactory{

	
	public static final String BLUE_CAST="BLUECAST";
	public static final String BLUE_EXPLOSION="BLUEEXPLOSION";
	public static final String BLUE_CHANNEL="BLUECHANNEL";
	public static final String BLUE_EIMPACT="BLUEIMPACT";
	
	@Override
	public Collection<Sprite> getSprites(String type) {
		
		
		if (BLUE_CAST.equals(type)){
			ProyectileSprite s= new ProyectileSprite(2);
			s.setOnFire(new ExplodeState("PARTICLE#blueCast","effects/FizzleNatureA"));
			return Arrays.asList((Sprite)s);
		}
		if (BLUE_EXPLOSION.equals(type)){
			ProyectileSprite s= new ProyectileSprite(2);
			s.setOnFire(new ExplodeState("PARTICLE#blueSparks","effects/IceCast"));
			return Arrays.asList((Sprite)s);
		}
		
		return null;
	}
}
