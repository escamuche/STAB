package com.stab.data.animation.sprite;

import java.util.Collection;

import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.factory.GeneralSpriteFactory;

public class StabSpriteFactory extends GeneralSpriteFactory{

	
	public StabSpriteFactory() {
		this.addFactory(new SpecialEffectsSpriteFactory());
		this.addFactory(new SpellsSpriteFactory());
		this.addFactory(new StabParticleFactory());
		setFactory(this);
	}
	
	@Override
	public Collection<Sprite> getSprites(String type) {
		// TODO Auto-generated method stub
		return super.getSprites(type);
	}
	
}
