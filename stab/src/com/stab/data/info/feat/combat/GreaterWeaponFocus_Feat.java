package com.stab.data.info.feat.combat;

import com.stab.data.StabConstants;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.trait.Modifier;

public class GreaterWeaponFocus_Feat extends CombatFeat{
	
	public static final String ID="GREATERWEAPONFOCUS_FEAT";

	
	
	public GreaterWeaponFocus_Feat() {
		
		this.addRequiredAttribute(StabConstants.BAB, 1);
		this.addRequiredTrait(WeaponFocus_Feat.ID);
		//this.addRequiredTrait(periciaarma);
		//this.addRequiredAttribute(fighter, 8);
		
		Modifier buff1=Modifier.createMod(StabConstants.TOHIT,+1);
		Modifier buff2=Modifier.createMod(StabConstants.TOHITRANGED,+1);
		addTrait(buff1);
		addTrait(buff2);
		
			}
	
}