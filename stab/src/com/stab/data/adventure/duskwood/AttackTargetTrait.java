package com.stab.data.adventure.duskwood;

import com.stab.model.ai.traits.Hatred;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;

public class AttackTargetTrait extends Hatred {

	Info target;
	
	public AttackTargetTrait(Info e) {
		super(e.getClass());
		this.target=e;
	}

	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		((Creature)baseInfo).becomeAwareOf(target);
	}
	
}
