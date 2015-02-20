package com.stab.pf.info.feat.combat;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.info.feat.CombatFeat;

public class GreaterWeaponFocus_Feat extends CombatFeat{
	
	public static final String ID="GREATERWEAPONFOCUS_FEAT";

	
	
	public GreaterWeaponFocus_Feat() {
		
		this.addRequiredAttribute(StabConstants.BAB, 1);
		this.addRequiredTrait(WeaponFocus_Feat.ID);
		//this.addRequiredTrait(periciaarma);
		//this.addRequiredAttribute(fighter, 8);
		
		Modifier buff1=new Modifier(StabConstants.TOHIT,+1);
		Modifier buff2=new Modifier(StabConstants.TOHITRANGED,+1);
		addTrait(buff1);
		addTrait(buff2);
		
			}
	
}