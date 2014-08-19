package com.stab.data.info.traits;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.AttributeBasedModifier;
import com.stab.model.info.trait.CompoundTrait;

public class BasicAttributes extends CompoundTrait{
	
	
	public BasicAttributes() {
		
		this.addTrait(new Attribute(StabConstants.STRENGHT,10));
		this.addTrait(new Attribute(StabConstants.DEXTERITY,10));
		this.addTrait(new Attribute(StabConstants.CONSTITUTION,10));
		this.addTrait(new Attribute(StabConstants.INTELLIGENCE,10));
		this.addTrait(new Attribute(StabConstants.WISDOM,10));
		this.addTrait(new Attribute(StabConstants.CHARISMA,10));
		this.addTrait(new Attribute(StabConstants.TOHIT,0));
		this.addTrait(new Attribute(StabConstants.TOHITRANGED,0));
		this.addTrait(new Attribute(StabConstants.BAB,0));
		this.addTrait(new Attribute(StabConstants.DAMAGE,0));
		this.addTrait(new Attribute(StabConstants.DAMAGERANGED,0));
		this.addTrait(new Attribute(StabConstants.SIZE,StabConstants.MEDIUM_SIZE));
		this.addTrait(new Attribute(StabConstants.PASSIVEDEFENSE,10));
		
		
		//TODO: retirarlo cuando esten en marcha las character class
		this.addTrait(new PathfinderAttributeBonus(StabConstants.MAXHP,StabConstants.CONSTITUTION));
		
		//Estos 4 puede que desaparezcan y sean sustituidos por valores calculados.
		this.addTrait(new DexLimitedBonusModifier(StabConstants.ACTIVEDEFENSE));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.DAMAGE,StabConstants.STRENGHT));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.TOHIT,StabConstants.STRENGHT));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.TOHITRANGED,StabConstants.DEXTERITY));
		this.addTrait(new AttributeBasedModifier(StabConstants.TOHIT,StabConstants.BAB));
		this.addTrait(new AttributeBasedModifier(StabConstants.TOHITRANGED,StabConstants.BAB));
		
		this.addTrait(new PathfinderAttributeBonus(StabConstants.FORTITUDESAVE,StabConstants.CONSTITUTION));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.REFLEXSAVE,StabConstants.DEXTERITY));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.WILLSAVE,StabConstants.WISDOM));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.INICIATIVEMOD,StabConstants.DEXTERITY));
		
		//CMD con sus modificaciones
		this.addTrait(new AttributeBasedModifier(StabConstants.CMD, StabConstants.BAB));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.CMD, StabConstants.DEXTERITY));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.CMD, StabConstants.STRENGHT));
		
		//Que es todo esto???
		/*this.addTrait(new AttributeBasedModifier(StabConstants.CMD, StabConstants.DEFLECTIONMOD));
		this.addTrait(new AttributeBasedModifier(StabConstants.CMD, StabConstants.INSIGHTMOD));
		this.addTrait(new AttributeBasedModifier(StabConstants.CMD, StabConstants.DODGEMOD));
		this.addTrait(new AttributeBasedModifier(StabConstants.CMD, StabConstants.LUCKMOD));
		this.addTrait(new AttributeBasedModifier(StabConstants.CMD, StabConstants.MORALMOD));
		this.addTrait(new AttributeBasedModifier(StabConstants.CMD, StabConstants.PROFANEMOD));
		this.addTrait(new AttributeBasedModifier(StabConstants.CMD, StabConstants.SACREDMOD));
		this.addTrait(new AttributeBasedModifier(StabConstants.CMD, StabConstants.CIRCUMSTANCEMOD));
		/**/
		
		//CMB con sus modificaciones
		this.addTrait(new AttributeBasedModifier(StabConstants.CMB, StabConstants.BAB));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.CMB, StabConstants.STRENGHT));
	
		
		this.addTrait(new SizeModifier(StabConstants.PASSIVEDEFENSE,+1));
		this.addTrait(new SizeModifier(StabConstants.TOHIT,+1));
		this.addTrait(new SizeModifier(StabConstants.TOHITRANGED,+1));
		//falta el bono a cmb, fly, stealth
		
		
		//Por simplificar para los logs, CA calculada
		this.addTrait(new AttributeBasedModifier(StabConstants.AC,StabConstants.PASSIVEDEFENSE));
		this.addTrait(new AttributeBasedModifier(StabConstants.AC,StabConstants.ACTIVEDEFENSE));
		this.addTrait(new AttributeBasedModifier(StabConstants.AC,StabConstants.ARMORDEFENSE));
		this.addTrait(new AttributeBasedModifier(StabConstants.AC,StabConstants.SHIELDDEFENSE));
		
		
		//Spellfailure
		this.addTrait(new ArmorArcaneFailure());
		
		//Modificadores a los skills por armorcheckPenalty
		this.addTrait(new AttributeBasedModifier(StabConstants.SWIMSKILL,StabConstants.ARMORCHECKPENALTY));
		//etc...
		
		//Attribute checks
		this.addTrait(new PathfinderAttributeBonus(StabConstants.STRENGHT_CHECK,StabConstants.STRENGHT));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.DEXTERITY_CHECK,StabConstants.DEXTERITY));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.CONSTITUTION_CHECK,StabConstants.CONSTITUTION));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.INTELLIGENCE_CHECK,StabConstants.INTELLIGENCE));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.WISDOM_CHECK,StabConstants.WISDOM));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.CHARISMA_CHECK,StabConstants.CHARISMA));
	}

}
