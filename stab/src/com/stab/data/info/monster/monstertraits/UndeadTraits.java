package com.stab.data.info.monster.monstertraits;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.info.feat.general.NaturalWeaponProficiency_Feat;
import com.stab.data.info.feat.general.SimpleWeaponProficiency_Feat;
import com.stab.data.info.traits.DescriptorImmunity;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.AttributeBasedModifier;
import com.stab.model.info.trait.CompoundTrait;

public class UndeadTraits extends RaceTraits {
	
	public static final String ID="UNDEADTRAITS";
	
	public UndeadTraits() {
	
		this.addTrait(new Attribute(StabConstants.HITDICETYPE,8));
		this.addTrait(new AttributeBasedModifier(StabConstants.BAB,StabConstants.HITDICENUMBER,0.75f));
		this.addTrait(new AttributeBasedModifier(StabConstants.FORTITUDESAVE,StabConstants.HITDICENUMBER,0.33f));
		this.addTrait(new AttributeBasedModifier(StabConstants.REFLEXSAVE,StabConstants.HITDICENUMBER,0.33f));
		this.addTrait(new AttributeBasedModifier(StabConstants.WILLSAVE,StabConstants.HITDICENUMBER,0.50f));
		this.addTrait(new Attribute(StabConstants.WILLSAVE,+2));
	
		this.addTrait(new NaturalWeaponProficiency_Feat());
		this.addTrait(new SimpleWeaponProficiency_Feat());
		
		this.addTrait(new DescriptorImmunity(EffectDescriptor.CHARM, EffectDescriptor.COMPULSION,EffectDescriptor.MIND_AFFECTING,EffectDescriptor.PATTERN,EffectDescriptor.PHANTASM));
		this.addTrait(new DescriptorImmunity(EffectDescriptor.DEATH, EffectDescriptor.POISON,EffectDescriptor.DISEASE,EffectDescriptor.STUN,EffectDescriptor.SLEEP,EffectDescriptor.FATIGUE));		
	}
}
