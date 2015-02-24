package com.stab.pf.animations.sprite;

import java.util.Collection;

import com.tien.princess.engine.sprite.Sprite;
import com.tien.princess.engine.sprite.factory.GeneralSpriteFactory;

public class StabSpriteFactory extends GeneralSpriteFactory{

	
	public StabSpriteFactory() {
	
		this.addFactory(new StabParticleFactory());
		this.addFactory(new SpecialEffectsSpriteFactory());
		this.addFactory(new SpellsSpriteFactory());
		
		setFactory(this);
	}
	

	
}
