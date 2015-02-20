package com.stab.pf.info.trait;

import com.stab.model.info.trait.CompoundTrait;
import com.stab.pf.StabConstants;
import com.stab.pf.info.applicable.SavingThrowEffect;

public class InanimateObjectTraits extends CompoundTrait {

	
	public InanimateObjectTraits() {
		
		
		AutomaticSaveResult ar= new AutomaticSaveResult(StabConstants.REFLEXSAVE, SavingThrowEffect.AUTOMATIC_FAIL);
		addTrait(ar);
		SneakAttackImmunnity si= new SneakAttackImmunnity();
		this.addTrait(si);
		
	}
	
}
