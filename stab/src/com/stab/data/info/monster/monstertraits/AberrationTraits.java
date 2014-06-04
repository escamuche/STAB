package com.stab.data.info.monster.monstertraits;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.combat.TowerShieldProficiency_Feat;
import com.stab.data.info.feat.general.HeavyArmorProficiency_Feat;
import com.stab.data.info.feat.general.LightArmorProficiency_Feat;
import com.stab.data.info.feat.general.MediumArmorProficiency_Feat;
import com.stab.data.info.feat.general.NaturalWeaponProficiency_Feat;
import com.stab.data.info.feat.general.ShieldProficiency_Feat;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.AttributeBasedModifier;
import com.stab.model.info.trait.CompoundTrait;

public class AberrationTraits extends RaceTraits {
	
	public AberrationTraits() {
	
		this.addTrait(new Attribute(StabConstants.HITDICETYPE,8));
		this.addTrait(new AttributeBasedModifier(StabConstants.BAB,StabConstants.HITDICENUMBER,0.75f));
		this.addTrait(new AttributeBasedModifier(StabConstants.FORTITUDESAVE,StabConstants.HITDICENUMBER,0.33f));
		this.addTrait(new AttributeBasedModifier(StabConstants.REFLEXSAVE,StabConstants.HITDICENUMBER,0.33f));
		this.addTrait(new AttributeBasedModifier(StabConstants.WILLSAVE,StabConstants.HITDICENUMBER,0.50f));
		this.addTrait(new Attribute(StabConstants.WILLSAVE,+2));
		this.addTrait(new NaturalWeaponProficiency_Feat());
		this.addTrait(new LightArmorProficiency_Feat());
		this.addTrait(new MediumArmorProficiency_Feat());
		this.addTrait(new HeavyArmorProficiency_Feat());
		this.addTrait(new ShieldProficiency_Feat());
		this.addTrait(new TowerShieldProficiency_Feat());
	}
}
