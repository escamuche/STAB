package com.stab.data.info.monster.monstertraits;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.general.NaturalWeaponProficiency_Feat;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.AttributeBasedModifier;

public class ConstructTraits extends RaceTraits {
	
	public ConstructTraits() {
	
		this.addTrait(new Attribute(StabConstants.HITDICETYPE,10));
		this.addTrait(new AttributeBasedModifier(StabConstants.BAB,StabConstants.HITDICENUMBER,1f));
		this.addTrait(new AttributeBasedModifier(StabConstants.FORTITUDESAVE,StabConstants.HITDICENUMBER,0.33f));
		this.addTrait(new AttributeBasedModifier(StabConstants.REFLEXSAVE,StabConstants.HITDICENUMBER,0.33f));
		this.addTrait(new AttributeBasedModifier(StabConstants.WILLSAVE,StabConstants.HITDICENUMBER,0.33f));
		
		this.addTrait(new NaturalWeaponProficiency_Feat());
		this.addTrait(new ConstructSizeExtraHpModifier());
	}
}