package com.stab.data.info.monster.monstertraits;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.AttributeBasedModifier;
import com.stab.model.info.trait.CompoundTrait;

public class AberrationTraits extends CompoundTrait {
	
	public AberrationTraits() {
	
		this.addTrait(new Attribute(StabConstants.HITDICETYPE,8));
		this.addTrait(new AttributeBasedModifier(StabConstants.BAB,StabConstants.HITDICENUMBER,0.75f));
		this.addTrait(new AttributeBasedModifier(StabConstants.FORTITUDESAVE,StabConstants.HITDICENUMBER,0.33f));
		this.addTrait(new AttributeBasedModifier(StabConstants.REFLEXSAVE,StabConstants.HITDICENUMBER,0.33f));
		this.addTrait(new AttributeBasedModifier(StabConstants.WILLSAVE,StabConstants.HITDICENUMBER,0.50f));
		this.addTrait(new Attribute(StabConstants.WILLSAVE,+2));
		
		
	}
}
