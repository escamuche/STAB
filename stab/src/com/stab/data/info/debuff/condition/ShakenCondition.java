package com.stab.data.info.debuff.condition;

import com.stab.data.StabConstants;
import com.stab.data.info.traits.AllSkillsModifier;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.DebuffEffect;

public class ShakenCondition extends DebuffEffect {

	
	public ShakenCondition() {
		
		this.setName("Shaken");
	 
		Modifier tohit=new Modifier(StabConstants.TOHIT, -2);
		Modifier tohitranged=new Modifier(StabConstants.TOHITRANGED, -2);
		Modifier damage=new Modifier(StabConstants.DAMAGE, -2);
		Modifier damageranged=new Modifier(StabConstants.DAMAGERANGED, -2);
		Modifier savef=new Modifier(StabConstants.FORTITUDESAVE, -2);
		Modifier saver=new Modifier(StabConstants.REFLEXSAVE, -2);
		Modifier savew=new Modifier(StabConstants.WILLSAVE, -2);
		AllSkillsModifier s = new AllSkillsModifier(null, -2);
		
		addTrait(tohit);
		addTrait(tohitranged);
		addTrait(damage);
		addTrait(damageranged);
		addTrait(savef);
		addTrait(saver);
		addTrait(savew);
		addTrait(s);
	}
}
