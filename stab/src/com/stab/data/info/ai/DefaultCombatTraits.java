package com.stab.data.info.ai;

import com.stab.model.ai.traits.Agressor;
import com.stab.model.ai.traits.DangerMapAI;
import com.stab.model.ai.traits.DistanceMapAI;
import com.stab.model.ai.traits.SelfPreservation;
import com.stab.model.info.trait.CompoundTrait;

public class DefaultCombatTraits extends CompoundTrait{

	public DefaultCombatTraits() {
	
		this.addTrait(new SelfPreservation());
		this.addTrait(new Agressor());
		this.addTrait(new FlankAI(1.0f));
		this.addTrait(new DangerMapAI());
		this.addTrait(new DistanceMapAI());
	}
	
}
