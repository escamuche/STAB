package com.stab.data.animation.sprite;

import java.util.Arrays;
import java.util.Collection;

import com.stab.data.actions.player.spells.wizard.level0.DisruptUndead;
import com.stab.data.animation.state.ExplodeState;
import com.tien.princess.engine.sprite.AbstractSpriteFactory;
import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.base.ProyectileSprite;

public class SpellsSpriteFactory extends AbstractSpriteFactory{

	
	
	@Override
	public Collection<Sprite> getSprites(String type) {
		
		if (DisruptUndead.ID.equals(type)){
			ProyectileSprite s= new ProyectileSprite(1000);
			ExplodeState x=new ExplodeState("PARTICLE#blueSparks",1000);
		
			s.setOnReach(x, 16);
			s.setOnFade(new ExplodeState("PARTICLE#blueSparks",1000));
			s.setOnFire(new ExplodeState("PARTICLE#blueCast",1000));
			return Arrays.asList((Sprite)s);
		}
		
		return null;

		
	}
	
}
