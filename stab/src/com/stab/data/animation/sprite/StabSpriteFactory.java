package com.stab.data.animation.sprite;

import com.tien.princess.engine.sprite.AbstractSpriteFactory;

public class StabSpriteFactory extends AbstractSpriteFactory{

	
	public StabSpriteFactory() {
		this.addFactory(new SpellsSpriteFactory());
	}
	
}
