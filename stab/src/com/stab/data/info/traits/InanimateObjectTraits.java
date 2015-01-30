package com.stab.data.info.traits;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.model.info.trait.CompoundTrait;

public class InanimateObjectTraits extends CompoundTrait {

	
	public InanimateObjectTraits() {
		
		
		AutomaticSaveResult ar= new AutomaticSaveResult(StabConstants.REFLEXSAVE, SavingThrowEffect.AUTOMATIC_FAIL);
		addTrait(ar);
		SneakAttackImmunnity si= new SneakAttackImmunnity();
		this.addTrait(si);
		
	}
	
}
