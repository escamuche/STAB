package com.stab.data.animation.sprite;

import com.tien.princess.engine.sprite.factory.GeneralSpriteFactory;

public class StabSpriteFactory extends GeneralSpriteFactory{

	
	public StabSpriteFactory() {
		this.addFactory(new SpecialEffectsSpriteFactory());
		this.addFactory(new SpellsSpriteFactory());
		this.addFactory(new StabParticleFactory());
		setFactory(this);
	}
	
}
