package com.stab.data.animation.sprite;

import com.tien.princess.engine.sprite.factory.AbstractSpriteFactory;

public class StabSpriteFactory extends AbstractSpriteFactory{

	
	public StabSpriteFactory() {
		this.addFactory(new SpecialEffectsSpriteFactory());
		this.addFactory(new SpellsSpriteFactory());
	}
	
}
