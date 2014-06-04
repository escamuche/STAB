package com.stab.data.info.monster.monstertraits;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.general.HeavyArmorProficiency_Feat;
import com.stab.data.info.feat.general.LightArmorProficiency_Feat;
import com.stab.data.info.feat.general.MartialWeaponProficiency_Feat;
import com.stab.data.info.feat.general.MediumArmorProficiency_Feat;
import com.stab.data.info.feat.general.ShieldProficiency_Feat;
import com.stab.data.info.feat.general.SimpleWeaponProficiency_Feat;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.AttributeBasedModifier;
import com.stab.model.info.trait.CompoundTrait;

public class OutsiderTraits extends RaceTraits {
	
	public OutsiderTraits() {
	
		this.addTrait(new Attribute(StabConstants.HITDICETYPE,10));
		this.addTrait(new AttributeBasedModifier(StabConstants.BAB,StabConstants.HITDICENUMBER,1f));
		this.addTrait(new AttributeBasedModifier(StabConstants.FORTITUDESAVE,StabConstants.HITDICENUMBER,0.33f));
		this.addTrait(new AttributeBasedModifier(StabConstants.REFLEXSAVE,StabConstants.HITDICENUMBER,0.50f));
		this.addTrait(new AttributeBasedModifier(StabConstants.WILLSAVE,StabConstants.HITDICENUMBER,0.50f));
		this.addTrait(new Attribute(StabConstants.WILLSAVE,+2));
		this.addTrait(new Attribute(StabConstants.REFLEXSAVE,+2));
		
		this.addTrait(new SimpleWeaponProficiency_Feat());
		this.addTrait(new MartialWeaponProficiency_Feat());
		this.addTrait(new LightArmorProficiency_Feat());
		this.addTrait(new MediumArmorProficiency_Feat());
		this.addTrait(new HeavyArmorProficiency_Feat());
		this.addTrait(new ShieldProficiency_Feat());
	
	}
}