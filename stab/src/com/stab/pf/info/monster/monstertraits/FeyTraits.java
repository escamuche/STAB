package com.stab.pf.info.monster.monstertraits;

import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.AttributeBasedModifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.general.SimpleWeaponProficiency_Feat;

public class FeyTraits extends RaceTraits {
	
	public FeyTraits() {
	
		this.addTrait(new Attribute(StabConstants.HITDICETYPE,6));
		this.addTrait(new AttributeBasedModifier(StabConstants.BAB,StabConstants.HITDICENUMBER,0.50f));
		this.addTrait(new AttributeBasedModifier(StabConstants.FORTITUDESAVE,StabConstants.HITDICENUMBER,0.33f));
		this.addTrait(new AttributeBasedModifier(StabConstants.REFLEXSAVE,StabConstants.HITDICENUMBER,0.50f));
		this.addTrait(new AttributeBasedModifier(StabConstants.WILLSAVE,StabConstants.HITDICENUMBER,0.50f));
		this.addTrait(new Attribute(StabConstants.WILLSAVE,+2));
		this.addTrait(new Attribute(StabConstants.REFLEXSAVE,+2));
		
		this.addTrait(new SimpleWeaponProficiency_Feat());
	}
}