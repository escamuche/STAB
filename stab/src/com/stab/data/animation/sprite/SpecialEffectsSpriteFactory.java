package com.stab.data.animation.sprite;

import java.util.Arrays;
import java.util.Collection;

import com.stab.common.Constants;
import com.stab.data.animation.state.ExplodeState;
import com.tien.princess.engine.Resources;
import com.tien.princess.engine.sprite.AbstractSpriteFactory;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.BeamSprite;
import com.tien.princess.engine.sprite.base.ProyectileSprite;

public class SpecialEffectsSpriteFactory extends  AbstractSpriteFactory{

	
	public static final String BLUE_CAST="BLUECAST";
	public static final String BLUE_EXPLOSION="BLUEEXPLOSION";
	public static final String BLUE_CHANNEL="BLUECHANNEL";
	public static final String BLUE_IMPACT="BLUEIMPACT";
	public static final String BLUE_BEAM="BLUEBEAMT";
	
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
		if (BLUE_BEAM.equals(type)){
			BeamSprite s= new BeamSprite();
			s.setImage(Resources.INSTANCE.getImage("effects/frostBeam"));
			s.setStyle(Constants.TILED);
			s.setWidth(16);
			return Arrays.asList((Sprite)s);
		}
		
		return null;
	}
}
