package com.stab.data.info.monster.monstertraits;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.general.NaturalWeaponProficiency_Feat;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.AttributeBasedModifier;

public class DragonTraits extends RaceTraits {
	
	public DragonTraits() {
	
		this.addTrait(new Attribute(StabConstants.HITDICETYPE,12));
		this.addTrait(new AttributeBasedModifier(StabConstants.BAB,StabConstants.HITDICENUMBER,1f));
		this.addTrait(new AttributeBasedModifier(StabConstants.FORTITUDESAVE,StabConstants.HITDICENUMBER,0.50f));
		this.addTrait(new AttributeBasedModifier(StabConstants.REFLEXSAVE,StabConstants.HITDICENUMBER,0.50f));
		this.addTrait(new AttributeBasedModifier(StabConstants.WILLSAVE,StabConstants.HITDICENUMBER,0.50f));
		this.addTrait(new Attribute(StabConstants.FORTITUDESAVE,+2));
		this.addTrait(new Attribute(StabConstants.REFLEXSAVE,+2));
		this.addTrait(new Attribute(StabConstants.WILLSAVE,+2));
		
		this.addTrait(new NaturalWeaponProficiency_Feat());
		
	}
}