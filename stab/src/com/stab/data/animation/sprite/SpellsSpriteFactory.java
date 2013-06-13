package com.stab.data.animation.sprite;

import java.util.Arrays;
import java.util.Collection;

import com.stab.data.actions.player.spells.wizard.level0.DisruptUndead;
import com.stab.data.animation.state.ExplodeState;
import com.tien.princess.engine.sprite.AbstractSpriteFactory;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.ProyectileSprite;
import com.tien.princess.engine.sprite.common.updaters.sound.LoopSound;

public class SpellsSpriteFactory extends AbstractSpriteFactory{

	public static final String CAST1="CAST1";
	
	@Override
	public Collection<Sprite> getSprites(String type) {
		
		
		if (CAST1.equals(type)){
			ProyectileSprite s= new ProyectileSprite(2);
			s.setOnFire(new ExplodeState("BlueCast","effects/FizzleNatureA"));
			return Arrays.asList((Sprite)s);
		}
		
		if (DisruptUndead.ID.equals(type)){
			ProyectileSprite s= new ProyectileSprite(1000);
			ExplodeState x=new ExplodeState("PARTICLE#blueSparks","effects/IceCast");
			s.getState(ProyectileSprite.TRAVEL).addUpdater(new LoopSound("effects/ArcaneExplosion"));
			s.setOnReach(x, 16);
			s.setOnFade(new ExplodeState("PARTICLE#blueSparks","effects/IceCast"));
			s.setOnFire(new ExplodeState(CAST1));
			return Arrays.asList((Sprite)s);
		}
		
		return null;

		
	}
	
}
