package com.stab.data.info;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Attribute;
import com.stab.model.info.trait.CompoundTrait;

public class BasicAttributes extends CompoundTrait{
	
	
	public BasicAttributes() {
		this.addTrait(new Attribute(StabConstants.STRENGHT,10));
		this.addTrait(new Attribute(StabConstants.DEXTERITY,10));
		this.addTrait(new Attribute(StabConstants.CONSTITUTION,10));
		this.addTrait(new Attribute(StabConstants.INTELIGENCE,10));
		this.addTrait(new Attribute(StabConstants.WISDOM,10));
		this.addTrait(new Attribute(StabConstants.CHARISMA,10));
		this.addTrait(new Attribute(StabConstants.TOHIT,0));
		this.addTrait(new Attribute(StabConstants.TOHITRANGED,0));
		this.addTrait(new Attribute(StabConstants.BAB,0));
		this.addTrait(new Attribute(StabConstants.DAMAGE,0));
		this.addTrait(new Attribute(StabConstants.DAMAGERANGED,0));
		//this.addTrait(new Attribute(StabConstants.ARMOR,10));
		this.addTrait(new Attribute(StabConstants.SIZE,StabConstants.MEDIUM_SIZE));
		this.addTrait(new Attribute(StabConstants.PASSIVEDEFENSE,10));
		
		//Estos 4 puede que desaparezcan y sean sustituidos por valores calculados.
		this.addTrait(new PathfinderAttributeBonus(StabConstants.ARMOR,StabConstants.DEXTERITY));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.DAMAGE,StabConstants.STRENGHT));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.TOHIT,StabConstants.STRENGHT));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.TOHITRANGED,StabConstants.DEXTERITY));
		
		this.addTrait(new PathfinderAttributeBonus(StabConstants.FORTITUDESAVE,StabConstants.CONSTITUTION));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.REFLEXSAVE,StabConstants.DEXTERITY));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.WILLSAVE,StabConstants.WISDOM));
		this.addTrait(new PathfinderAttributeBonus(StabConstants.INICIATIVEMOD,StabConstants.DEXTERITY));
		
		this.addTrait(new SizeModifier(StabConstants.PASSIVEDEFENSE,+1));
		this.addTrait(new SizeModifier(StabConstants.TOHIT,+1));
		this.addTrait(new SizeModifier(StabConstants.TOHITRANGED,+1));
		//falta el bono a cmb, fly, stealth
		
	}

}
